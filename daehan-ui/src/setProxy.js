const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
    app.use(
        createProxyMiddleware("/api/test", {
            target: "http://localhost:9001",
            changeOrigin: true,
        })
    );
};
