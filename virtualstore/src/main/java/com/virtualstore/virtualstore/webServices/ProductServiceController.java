package com.virtualstore.virtualstore.webServices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.virtualstore.virtualstore.dtos.ProductBasicInfo;
import com.virtualstore.virtualstore.entities.Product;
import com.virtualstore.virtualstore.mappers.ProductMapper;
import com.virtualstore.virtualstore.responses.GenericResponse;
import com.virtualstore.virtualstore.services.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("${url.product}")
public class ProductServiceController {

    @Autowired
    private ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping
    public ResponseEntity<Object> getProducts() {

        Collection<ProductBasicInfo> products = productMapper.productsToProductBasicInfos(productService.getProducts());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") Long id) {

        try {
            Product foundProduct = productService.getProduct(id);
            return new ResponseEntity<>(productMapper.productToProductBasicInfo(foundProduct), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createProduct(@RequestBody Product product) {
        GenericResponse response;
        try {
            //if (productService.getProduct(product.getId()) == null) {
                
                product.setImage("/images/"+ product.getImage());
                productService.createProduct(product);
                response = new GenericResponse().setToken(null).setExpiresIn(0).setError(false).setData(productMapper.productToProductBasicInfo(product)).setMsg("Producto agregado");
                return ResponseEntity.ok(response);
            //} else {
            //    throw new Exception("Product already exists");
           // }

        } catch (Exception e) {
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<GenericResponse> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        GenericResponse response;
        try {
            productService.updateProduct(id, product);
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(false).setData(productMapper.productToProductBasicInfo(product)).setMsg("Producto actualizado");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<GenericResponse> delete(@PathVariable("id") Long id) {
        GenericResponse response;
        try {
            productService.deleteProduct(id);
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(false).setData(id).setMsg("Producto eliminado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg("Error al eliminar el producto");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping(path = "/images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<GenericResponse> uploadImage(@RequestPart MultipartFile file) {
        GenericResponse response;
        try {
            // Save the file to the directory
            String filePath = saveImage(file);
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(false).setData(null).setMsg("Foto amacenada en " + filePath);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }


    private String saveImage(MultipartFile file) throws IOException {

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString();
    }

}
