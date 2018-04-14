export const environment = {
    production: true,
    api: {
        pets: {
            collection: "/api/pets",
            item: "/api/pets/_ID_",
            deleteBatch: "/api/pets/batch/_ID_",
            types: "/api/pets/types"
        },
        owners: {
            collection: "/api/owners",
            item: "/api/owners/_ID_"
        }
    }
};
