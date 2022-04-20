package app.models;

import java.io.Serializable;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public class CustomArray implements UserType {

	@Override
	public int[] sqlTypes() {

		return new int[] { Types.ARRAY };
	}

	@Override
	public Class returnedClass() {

		return Like[].class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		if (x instanceof Like[] && y instanceof Like[]) {
			return Arrays.deepEquals((Like[]) x, (Like[]) y);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return Arrays.hashCode((Like[]) x);
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] likes, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		Array array = rs.getArray(likes[0]);
		return array != null ? array.getArray() : null;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		if (value != null && st != null) {
			Array array = session.connection().createArrayOf("text", (Like[]) value);
		} else {
			st.setNull(index, sqlTypes()[0]);
		}

	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}
}
