package com.knowledge.asyn.tx.web;

import com.knowledge.asyn.tx.entities.Product;
import com.knowledge.asyn.tx.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "产品服务接口")
@RequestMapping("/productController")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "创建产品", notes = "创建产品")
    @ApiImplicitParam(name = "product", value = "产品信息的实体", required = true, dataType = "Product")
    @PostMapping("/prod")
    public ResponseEntity<Void> addProduct(Product product) {
        this.productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "删除产品", notes = "根据url的id来指定id产品")
    @ApiImplicitParam(name = "id", value = "产品标识ID", required = true, dataType = "Integer", paramType = "path")
    @DeleteMapping("/prod/{id}")
    public ResponseEntity<Void> delProduct(@PathVariable("id") Integer id) {
        this.productService.removeById(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @ApiOperation(value = "更新信息", notes = "更新产品信息")
    @ApiImplicitParam(name = "product", value = "产品实体product", required = true, dataType = "Product")
    @PutMapping("/prod")
    public ResponseEntity<Void> updateProduct(Product product) {
        this.productService.updateById(product);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "获取产品的详细信息", notes = "根据url的id来获取产品的详细信息")
    @ApiImplicitParam(name = "id", value = "产品标识", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/prod/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
        Product product = productService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @ApiOperation(value = "获取全部的产品信息", notes = "根据url来获取全部的产品信息")
    @GetMapping("/prods")
    public ResponseEntity<List<Product>> queryAll() {
        List<Product> productList = productService.list();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

}
