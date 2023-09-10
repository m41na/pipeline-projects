const env = process.env;

const config = () => ({
    db: { /* do not put password or any sensitive info here, done only for demo */
        host: process.env.DB_HOST || 'localhost',
        port: process.env.DB_PORT || '5432',
        user: process.env.DB_USER || 'postgres',
        password: process.env.DB_PASSWORD,
        database: process.env.DB_NAME || 'postgres',
    },
    listPerPage: process.env.LIST_PER_PAGE || 10,
});

module.exports = config();