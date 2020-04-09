## 1、applicationId 

在gradle中的applicationId，最后会覆盖Mainfest中applicationId

## 2、分渠道

### 2.1、productFlavors和flavorDimensions

flavorDimensions：维度风格，用法如下

```
flavorDimensions "1","2"
productFlavors {
    china {
        applicationId "com.example.china"
        dimension "1"
    }
    usa {
        applicationId "com.example.usa"
        dimension "1"
    }
    charge {
        versionCode 2
        dimension "2"
    }
    free {
        versionCode 3
        dimension "2"
    }
}

四种组合：
chinacharge
chinafree
usacharge
usafree

```

### 2.2 分渠道不同配置 

applicationId、applicationIdSuffix、versionCode（注意：高维度会覆盖低纬度）
    
### 2.3 variantFilter 过滤一些不要的渠道

```
variantFilter { variant ->
        def names = variant.flavors*.name
        def types = variant.buildType.name
        if (names.contains("free") && types == "debug") {
            setIgnore(true)
        }
    }
```

### 2.4 applicationIdSuffix

在applicationId后加后缀

### 2.5 buildConfigField

在buildConfig中新增变量

### 2.6 resValue

在res/value 新增变量

### 2.7 signingConfigs

配置签名信息，注意在release Type下一定需要签名不然不能跑

```
signingConfigs {
        debugConfig {
            keyAlias "key"
            keyPassword "111111"
            storeFile file("/key.jks")
            storePassword "111111"
        }
        releaseConfig {
            keyAlias "key"
            keyPassword "111111"
            storeFile file("/key.jks")
            storePassword "111111"
        }
    }
```
