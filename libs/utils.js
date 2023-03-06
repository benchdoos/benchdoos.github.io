function findAsset(assets, pattern) {
    for (const asset of assets) {
        if (asset.name.match(pattern)) {
            console.log("asset found by name: " + pattern + "; " + JSON.stringify(asset));
            return asset;
        }
    }
}