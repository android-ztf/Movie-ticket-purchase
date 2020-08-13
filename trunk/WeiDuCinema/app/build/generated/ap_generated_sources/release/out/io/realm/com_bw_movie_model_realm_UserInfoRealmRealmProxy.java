package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_bw_movie_model_realm_UserInfoRealmRealmProxy extends com.bw.movie.model.realm.UserInfoRealm
    implements RealmObjectProxy, com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface {

    static final class UserInfoRealmColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long headPicIndex;
        long nickNameIndex;
        long phoneIndex;
        long sessionIdIndex;
        long sexIndex;
        long userIdIndex;

        UserInfoRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("UserInfoRealm");
            this.headPicIndex = addColumnDetails("headPic", "headPic", objectSchemaInfo);
            this.nickNameIndex = addColumnDetails("nickName", "nickName", objectSchemaInfo);
            this.phoneIndex = addColumnDetails("phone", "phone", objectSchemaInfo);
            this.sessionIdIndex = addColumnDetails("sessionId", "sessionId", objectSchemaInfo);
            this.sexIndex = addColumnDetails("sex", "sex", objectSchemaInfo);
            this.userIdIndex = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        UserInfoRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserInfoRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserInfoRealmColumnInfo src = (UserInfoRealmColumnInfo) rawSrc;
            final UserInfoRealmColumnInfo dst = (UserInfoRealmColumnInfo) rawDst;
            dst.headPicIndex = src.headPicIndex;
            dst.nickNameIndex = src.nickNameIndex;
            dst.phoneIndex = src.phoneIndex;
            dst.sessionIdIndex = src.sessionIdIndex;
            dst.sexIndex = src.sexIndex;
            dst.userIdIndex = src.userIdIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserInfoRealmColumnInfo columnInfo;
    private ProxyState<com.bw.movie.model.realm.UserInfoRealm> proxyState;

    com_bw_movie_model_realm_UserInfoRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserInfoRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.bw.movie.model.realm.UserInfoRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$headPic() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.headPicIndex);
    }

    @Override
    public void realmSet$headPic(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.headPicIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.headPicIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.headPicIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.headPicIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nickName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nickNameIndex);
    }

    @Override
    public void realmSet$nickName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nickNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nickNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nickNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nickNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$phone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.phoneIndex);
    }

    @Override
    public void realmSet$phone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.phoneIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.phoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.phoneIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.phoneIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sessionId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sessionIdIndex);
    }

    @Override
    public void realmSet$sessionId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sessionIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sessionIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sessionIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sessionIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$sex() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.sexIndex);
    }

    @Override
    public void realmSet$sex(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.sexIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.sexIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$userId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.userIdIndex);
    }

    @Override
    public void realmSet$userId(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'userId' cannot be changed after object was created.");
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("UserInfoRealm", 6, 0);
        builder.addPersistedProperty("headPic", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nickName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("phone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sessionId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sex", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("userId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserInfoRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserInfoRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "UserInfoRealm";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "UserInfoRealm";
    }

    @SuppressWarnings("cast")
    public static com.bw.movie.model.realm.UserInfoRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.bw.movie.model.realm.UserInfoRealm obj = null;
        if (update) {
            Table table = realm.getTable(com.bw.movie.model.realm.UserInfoRealm.class);
            UserInfoRealmColumnInfo columnInfo = (UserInfoRealmColumnInfo) realm.getSchema().getColumnInfo(com.bw.movie.model.realm.UserInfoRealm.class);
            long pkColumnIndex = columnInfo.userIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("userId")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("userId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.bw.movie.model.realm.UserInfoRealm.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_bw_movie_model_realm_UserInfoRealmRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("userId")) {
                if (json.isNull("userId")) {
                    obj = (io.realm.com_bw_movie_model_realm_UserInfoRealmRealmProxy) realm.createObjectInternal(com.bw.movie.model.realm.UserInfoRealm.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_bw_movie_model_realm_UserInfoRealmRealmProxy) realm.createObjectInternal(com.bw.movie.model.realm.UserInfoRealm.class, json.getInt("userId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userId'.");
            }
        }

        final com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface objProxy = (com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) obj;
        if (json.has("headPic")) {
            if (json.isNull("headPic")) {
                objProxy.realmSet$headPic(null);
            } else {
                objProxy.realmSet$headPic((String) json.getString("headPic"));
            }
        }
        if (json.has("nickName")) {
            if (json.isNull("nickName")) {
                objProxy.realmSet$nickName(null);
            } else {
                objProxy.realmSet$nickName((String) json.getString("nickName"));
            }
        }
        if (json.has("phone")) {
            if (json.isNull("phone")) {
                objProxy.realmSet$phone(null);
            } else {
                objProxy.realmSet$phone((String) json.getString("phone"));
            }
        }
        if (json.has("sessionId")) {
            if (json.isNull("sessionId")) {
                objProxy.realmSet$sessionId(null);
            } else {
                objProxy.realmSet$sessionId((String) json.getString("sessionId"));
            }
        }
        if (json.has("sex")) {
            if (json.isNull("sex")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sex' to null.");
            } else {
                objProxy.realmSet$sex((int) json.getInt("sex"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.bw.movie.model.realm.UserInfoRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.bw.movie.model.realm.UserInfoRealm obj = new com.bw.movie.model.realm.UserInfoRealm();
        final com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface objProxy = (com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("headPic")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$headPic((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$headPic(null);
                }
            } else if (name.equals("nickName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nickName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nickName(null);
                }
            } else if (name.equals("phone")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$phone((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$phone(null);
                }
            } else if (name.equals("sessionId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sessionId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sessionId(null);
                }
            } else if (name.equals("sex")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sex((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sex' to null.");
                }
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'userId' to null.");
                }
                jsonHasPrimaryKey = true;
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_bw_movie_model_realm_UserInfoRealmRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.bw.movie.model.realm.UserInfoRealm.class), false, Collections.<String>emptyList());
        io.realm.com_bw_movie_model_realm_UserInfoRealmRealmProxy obj = new io.realm.com_bw_movie_model_realm_UserInfoRealmRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.bw.movie.model.realm.UserInfoRealm copyOrUpdate(Realm realm, UserInfoRealmColumnInfo columnInfo, com.bw.movie.model.realm.UserInfoRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.bw.movie.model.realm.UserInfoRealm) cachedRealmObject;
        }

        com.bw.movie.model.realm.UserInfoRealm realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.bw.movie.model.realm.UserInfoRealm.class);
            long pkColumnIndex = columnInfo.userIdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_bw_movie_model_realm_UserInfoRealmRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.bw.movie.model.realm.UserInfoRealm copy(Realm realm, UserInfoRealmColumnInfo columnInfo, com.bw.movie.model.realm.UserInfoRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.bw.movie.model.realm.UserInfoRealm) cachedRealmObject;
        }

        com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface realmObjectSource = (com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) newObject;

        Table table = realm.getTable(com.bw.movie.model.realm.UserInfoRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.headPicIndex, realmObjectSource.realmGet$headPic());
        builder.addString(columnInfo.nickNameIndex, realmObjectSource.realmGet$nickName());
        builder.addString(columnInfo.phoneIndex, realmObjectSource.realmGet$phone());
        builder.addString(columnInfo.sessionIdIndex, realmObjectSource.realmGet$sessionId());
        builder.addInteger(columnInfo.sexIndex, realmObjectSource.realmGet$sex());
        builder.addInteger(columnInfo.userIdIndex, realmObjectSource.realmGet$userId());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_bw_movie_model_realm_UserInfoRealmRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.bw.movie.model.realm.UserInfoRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.bw.movie.model.realm.UserInfoRealm.class);
        long tableNativePtr = table.getNativePtr();
        UserInfoRealmColumnInfo columnInfo = (UserInfoRealmColumnInfo) realm.getSchema().getColumnInfo(com.bw.movie.model.realm.UserInfoRealm.class);
        long pkColumnIndex = columnInfo.userIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$headPic = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$headPic();
        if (realmGet$headPic != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.headPicIndex, rowIndex, realmGet$headPic, false);
        }
        String realmGet$nickName = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$nickName();
        if (realmGet$nickName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nickNameIndex, rowIndex, realmGet$nickName, false);
        }
        String realmGet$phone = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$phone();
        if (realmGet$phone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
        }
        String realmGet$sessionId = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$sessionId();
        if (realmGet$sessionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sessionIdIndex, rowIndex, realmGet$sessionId, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.sexIndex, rowIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$sex(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.bw.movie.model.realm.UserInfoRealm.class);
        long tableNativePtr = table.getNativePtr();
        UserInfoRealmColumnInfo columnInfo = (UserInfoRealmColumnInfo) realm.getSchema().getColumnInfo(com.bw.movie.model.realm.UserInfoRealm.class);
        long pkColumnIndex = columnInfo.userIdIndex;
        com.bw.movie.model.realm.UserInfoRealm object = null;
        while (objects.hasNext()) {
            object = (com.bw.movie.model.realm.UserInfoRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$headPic = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$headPic();
            if (realmGet$headPic != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.headPicIndex, rowIndex, realmGet$headPic, false);
            }
            String realmGet$nickName = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$nickName();
            if (realmGet$nickName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nickNameIndex, rowIndex, realmGet$nickName, false);
            }
            String realmGet$phone = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$phone();
            if (realmGet$phone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
            }
            String realmGet$sessionId = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$sessionId();
            if (realmGet$sessionId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sessionIdIndex, rowIndex, realmGet$sessionId, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.sexIndex, rowIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$sex(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.bw.movie.model.realm.UserInfoRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.bw.movie.model.realm.UserInfoRealm.class);
        long tableNativePtr = table.getNativePtr();
        UserInfoRealmColumnInfo columnInfo = (UserInfoRealmColumnInfo) realm.getSchema().getColumnInfo(com.bw.movie.model.realm.UserInfoRealm.class);
        long pkColumnIndex = columnInfo.userIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId());
        }
        cache.put(object, rowIndex);
        String realmGet$headPic = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$headPic();
        if (realmGet$headPic != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.headPicIndex, rowIndex, realmGet$headPic, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.headPicIndex, rowIndex, false);
        }
        String realmGet$nickName = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$nickName();
        if (realmGet$nickName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nickNameIndex, rowIndex, realmGet$nickName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nickNameIndex, rowIndex, false);
        }
        String realmGet$phone = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$phone();
        if (realmGet$phone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneIndex, rowIndex, false);
        }
        String realmGet$sessionId = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$sessionId();
        if (realmGet$sessionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sessionIdIndex, rowIndex, realmGet$sessionId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sessionIdIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.sexIndex, rowIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$sex(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.bw.movie.model.realm.UserInfoRealm.class);
        long tableNativePtr = table.getNativePtr();
        UserInfoRealmColumnInfo columnInfo = (UserInfoRealmColumnInfo) realm.getSchema().getColumnInfo(com.bw.movie.model.realm.UserInfoRealm.class);
        long pkColumnIndex = columnInfo.userIdIndex;
        com.bw.movie.model.realm.UserInfoRealm object = null;
        while (objects.hasNext()) {
            object = (com.bw.movie.model.realm.UserInfoRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$userId());
            }
            cache.put(object, rowIndex);
            String realmGet$headPic = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$headPic();
            if (realmGet$headPic != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.headPicIndex, rowIndex, realmGet$headPic, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.headPicIndex, rowIndex, false);
            }
            String realmGet$nickName = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$nickName();
            if (realmGet$nickName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nickNameIndex, rowIndex, realmGet$nickName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nickNameIndex, rowIndex, false);
            }
            String realmGet$phone = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$phone();
            if (realmGet$phone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.phoneIndex, rowIndex, false);
            }
            String realmGet$sessionId = ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$sessionId();
            if (realmGet$sessionId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sessionIdIndex, rowIndex, realmGet$sessionId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sessionIdIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.sexIndex, rowIndex, ((com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) object).realmGet$sex(), false);
        }
    }

    public static com.bw.movie.model.realm.UserInfoRealm createDetachedCopy(com.bw.movie.model.realm.UserInfoRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.bw.movie.model.realm.UserInfoRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.bw.movie.model.realm.UserInfoRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.bw.movie.model.realm.UserInfoRealm) cachedObject.object;
            }
            unmanagedObject = (com.bw.movie.model.realm.UserInfoRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface unmanagedCopy = (com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) unmanagedObject;
        com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface realmSource = (com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$headPic(realmSource.realmGet$headPic());
        unmanagedCopy.realmSet$nickName(realmSource.realmGet$nickName());
        unmanagedCopy.realmSet$phone(realmSource.realmGet$phone());
        unmanagedCopy.realmSet$sessionId(realmSource.realmGet$sessionId());
        unmanagedCopy.realmSet$sex(realmSource.realmGet$sex());
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());

        return unmanagedObject;
    }

    static com.bw.movie.model.realm.UserInfoRealm update(Realm realm, UserInfoRealmColumnInfo columnInfo, com.bw.movie.model.realm.UserInfoRealm realmObject, com.bw.movie.model.realm.UserInfoRealm newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface realmObjectTarget = (com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) realmObject;
        com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface realmObjectSource = (com_bw_movie_model_realm_UserInfoRealmRealmProxyInterface) newObject;
        Table table = realm.getTable(com.bw.movie.model.realm.UserInfoRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.headPicIndex, realmObjectSource.realmGet$headPic());
        builder.addString(columnInfo.nickNameIndex, realmObjectSource.realmGet$nickName());
        builder.addString(columnInfo.phoneIndex, realmObjectSource.realmGet$phone());
        builder.addString(columnInfo.sessionIdIndex, realmObjectSource.realmGet$sessionId());
        builder.addInteger(columnInfo.sexIndex, realmObjectSource.realmGet$sex());
        builder.addInteger(columnInfo.userIdIndex, realmObjectSource.realmGet$userId());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("UserInfoRealm = proxy[");
        stringBuilder.append("{headPic:");
        stringBuilder.append(realmGet$headPic() != null ? realmGet$headPic() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nickName:");
        stringBuilder.append(realmGet$nickName() != null ? realmGet$nickName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phone:");
        stringBuilder.append(realmGet$phone() != null ? realmGet$phone() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sessionId:");
        stringBuilder.append(realmGet$sessionId() != null ? realmGet$sessionId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sex:");
        stringBuilder.append(realmGet$sex());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_bw_movie_model_realm_UserInfoRealmRealmProxy aUserInfoRealm = (com_bw_movie_model_realm_UserInfoRealmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUserInfoRealm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUserInfoRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUserInfoRealm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
