package com.bw.movie.model.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ADDRESS".
*/
public class AddressDao extends AbstractDao<Address, Long> {

    public static final String TABLENAME = "ADDRESS";

    /**
     * Properties of entity Address.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Address = new Property(1, String.class, "address", false, "ADDRESS");
        public final static Property Latitude = new Property(2, double.class, "latitude", false, "LATITUDE");
        public final static Property Longitude = new Property(3, double.class, "longitude", false, "LONGITUDE");
    }


    public AddressDao(DaoConfig config) {
        super(config);
    }
    
    public AddressDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ADDRESS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: id
                "\"ADDRESS\" TEXT," + // 1: address
                "\"LATITUDE\" REAL NOT NULL ," + // 2: latitude
                "\"LONGITUDE\" REAL NOT NULL );"); // 3: longitude
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_ADDRESS_ADDRESS ON \"ADDRESS\"" +
                " (\"ADDRESS\" ASC);");
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_ADDRESS_LATITUDE ON \"ADDRESS\"" +
                " (\"LATITUDE\" ASC);");
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_ADDRESS_LONGITUDE ON \"ADDRESS\"" +
                " (\"LONGITUDE\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ADDRESS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Address entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(2, address);
        }
        stmt.bindDouble(3, entity.getLatitude());
        stmt.bindDouble(4, entity.getLongitude());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Address entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(2, address);
        }
        stmt.bindDouble(3, entity.getLatitude());
        stmt.bindDouble(4, entity.getLongitude());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Address readEntity(Cursor cursor, int offset) {
        Address entity = new Address( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // address
            cursor.getDouble(offset + 2), // latitude
            cursor.getDouble(offset + 3) // longitude
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Address entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setAddress(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLatitude(cursor.getDouble(offset + 2));
        entity.setLongitude(cursor.getDouble(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Address entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Address entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Address entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}