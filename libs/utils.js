function findAsset(assets, pattern) {
    for (const asset of assets) {
        if (asset.name.match(pattern)) {
            return asset;
        }
    }
}