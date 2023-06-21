const { defineConfig } = require('@vue/cli-service')
//module.exports = defineConfig({
//  transpileDependencies: true
//})
module.exports = {
    // npm run build 타겟 디렉토리
    outputDir: '../src/main/java/resources/static',

    // npm run serve
    devServer: {
        proxy: 'http://localhost:8080'
    }
};