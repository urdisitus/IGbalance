import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class Esquema {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Schema esquema = new Schema(1,
				"com.ernesto.perez.balancepersonal.entidades");
		esquema.setDefaultJavaPackageDao("com.ernesto.perez.balancepersonal.daos");
		esquema.enableKeepSectionsByDefault();
		esquema.enableActiveEntitiesByDefault();
		// addPerfil(esquema);

		Entity imagen = esquema.addEntity("Imagen");
		imagen.addIdProperty().autoincrement();
		imagen.addStringProperty("direccionFisica");
		imagen.addIntProperty("tipoImagen").notNull();
		imagen.addStringProperty("nombre").notNull();
		imagen.addDateProperty("fechaModificacion").notNull();

		Entity banco = esquema.addEntity("Banco");
		banco.addIdProperty().autoincrement();
		banco.addStringProperty("nombre").notNull();
		banco.addIntProperty("tipo").notNull();
		banco.addDateProperty("fechaModificacion").notNull();
		banco.addToOne(imagen, banco.addLongProperty("idImagen").getProperty(),
				"logo");

		Entity origenFinanciero = esquema.addEntity("OrigenFinanciero");
		origenFinanciero.addIdProperty().autoincrement();
		origenFinanciero.addIntProperty("estado").notNull();
		origenFinanciero.addStringProperty("nombre").notNull();
		origenFinanciero.addDoubleProperty("saldo").notNull();
		origenFinanciero.addToOne(imagen,
				origenFinanciero.addLongProperty("idImagen").getProperty(),
				"logo");

		Entity cuenta = esquema.addEntity("Cuenta");
		Property OrigenFToCuenta = cuenta.addLongProperty("idOrigenFinanciero")
				.primaryKey().getProperty();
		cuenta.addStringProperty("nroCuenta").notNull();
		Property BancoToCueta = cuenta.addLongProperty("idBanco").notNull()
				.getProperty();
		cuenta.addToOne(origenFinanciero, OrigenFToCuenta, "cuenta");
		banco.addToMany(cuenta, BancoToCueta, "cuentas");
		cuenta.addToOne(banco, BancoToCueta, "banco");

		// Entity tipoCategoria = esquema.addEntity("TipoCategoria");
		// tipoCategoria.addIdProperty().autoincrement();
		// tipoCategoria.addStringProperty("nombre").notNull();
		// tipoCategoria.addIntProperty("tipo").notNull();
		//

		Entity categoria = esquema.addEntity("Categoria");
		categoria.addIdProperty().autoincrement();
		categoria.addStringProperty("nombre").notNull();
		categoria.addStringProperty("descripcion").notNull();
		categoria.addIntProperty("tipoCategoria").notNull();
		categoria.addIntProperty("estado").notNull();
		categoria.addToOne(imagen, categoria.addLongProperty("idImagen")
				.getProperty(), "logo");

		Entity adjunto = esquema.addEntity("Adjunto");
		adjunto.addIdProperty().autoincrement();
		adjunto.addStringProperty("nota");
		adjunto.addToOne(imagen, adjunto.addLongProperty("idImagen")
				.getProperty(), "imagenAdjunta");

		Entity anulacionMovimiento = esquema.addEntity("AnulacionMov");
		anulacionMovimiento.addIdProperty().autoincrement();
		anulacionMovimiento.addDateProperty("fechaHora").notNull();
		anulacionMovimiento.addStringProperty("motivo").notNull();

		Entity movimiento = esquema.addEntity("Movimiento");
		movimiento.addIdProperty().autoincrement();
		movimiento.addStringProperty("concepto").notNull();
		movimiento.addDateProperty("fechaHora").notNull();
		movimiento.addDoubleProperty("latitud").notNull();
		movimiento.addDoubleProperty("longitud").notNull();
		movimiento.addDoubleProperty("importe").notNull();
		Property categoriaToMovimiento = movimiento
				.addLongProperty("idCategoria").notNull().getProperty();
		Property origenFinToMovimiento = movimiento
				.addLongProperty("idOrigenFinanciero").notNull().getProperty();
		movimiento.addToOne(anulacionMovimiento,
				movimiento.addLongProperty("idAnulacion").getProperty(),
				"anulacion");
		movimiento.addIntProperty("estado").notNull();
		movimiento.addToOne(adjunto, movimiento.addLongProperty("idAdjunto")
				.getProperty(), "adjunto");
		movimiento.addToOne(categoria, categoriaToMovimiento, "categoria");
		categoria.addToMany(movimiento, categoriaToMovimiento, "movimientos");
		movimiento.addToOne(origenFinanciero, origenFinToMovimiento,
				"movimientos");
		origenFinanciero.addToMany(movimiento, origenFinToMovimiento,
				"origenFinanciero");

		Entity movimientoPeriodico = esquema.addEntity("MovimientoPeriodico");
		movimientoPeriodico.addIdProperty().autoincrement();
		movimientoPeriodico.addDateProperty("fechaModificacion").notNull();
		movimientoPeriodico.addIntProperty("intervalo").notNull();
		movimientoPeriodico.addIntProperty("estado").notNull();
		movimientoPeriodico.addDoubleProperty("importe").notNull();
		Property categoriaToMovimientoP = movimientoPeriodico
				.addLongProperty("idCategoria").notNull().getProperty();
		Property origenFinToMovimientoP = movimientoPeriodico
				.addLongProperty("idOrigenFinanciero").notNull().getProperty();
		movimientoPeriodico.addToOne(categoria, categoriaToMovimientoP,
				"categoria");
		categoria.addToMany(movimientoPeriodico, origenFinToMovimientoP,
				"movimientosPeriodicos");
		movimientoPeriodico.addToOne(origenFinanciero, origenFinToMovimientoP,
				"origenFinanciero");
		origenFinanciero.addToMany(movimientoPeriodico, origenFinToMovimientoP,
				"movimientosPeriodicos");

		Entity detallePeriodico = esquema.addEntity("DetalleMovPeriodico");
		detallePeriodico.addIdProperty().autoincrement();
		Property movPToDetalleMovP = detallePeriodico
				.addLongProperty("idMovPeriodico").notNull().getProperty();
		Property movToDetalleMovP = detallePeriodico
				.addLongProperty("idMovimiento").notNull().getProperty();
		detallePeriodico.addToMany(movimientoPeriodico, movPToDetalleMovP,
				"movimientoPeriodico");
		detallePeriodico.addToOne(movimiento, movToDetalleMovP, "movimiento");
		movimientoPeriodico.addToMany(detallePeriodico, movPToDetalleMovP,
				"detalleMovimientoPeriodico");

		Entity contacto = esquema.addEntity("Contacto");
		contacto.addIdProperty().autoincrement();
		contacto.addStringProperty("nombre").notNull();
		contacto.addStringProperty("email").notNull();
		contacto.addToOne(imagen, contacto.addLongProperty("idFoto").notNull()
				.getProperty(), "foto");

		Entity telefono = esquema.addEntity("Telefono");
		telefono.addIdProperty().autoincrement();
		telefono.addStringProperty("telefono").notNull();
		Property contactoToTelefono = telefono.addLongProperty("idContacto")
				.notNull().getProperty();
		contacto.addToMany(telefono, contactoToTelefono, "telefonos");
		telefono.addToOne(contacto, contactoToTelefono, "contacto");

		Entity prestamo = esquema.addEntity("Prestamo");
		prestamo.addIdProperty().autoincrement();
		prestamo.addDateProperty("fechaHora").notNull();
		prestamo.addDoubleProperty("monto").notNull();
		prestamo.addIntProperty("estado").notNull();
		prestamo.addDoubleProperty("saldo").notNull();
		prestamo.addDoubleProperty("montoPagado").notNull();
		Property contactoToPrestamo = prestamo.addLongProperty("idContacto")
				.notNull().getProperty();
		contacto.addToMany(prestamo, contactoToPrestamo, "prestamos");
		prestamo.addToOne(contacto, contactoToPrestamo, "contacto");

		Entity detallePrestamo = esquema.addEntity("detallePrestamo");
		detallePrestamo.addIdProperty().autoincrement();
		Property prestamoToDetallePrestamo = detallePrestamo
				.addLongProperty("idPrestamo").notNull().getProperty();
		Property movimientoToDetallePrestamo = detallePrestamo
				.addLongProperty("idMovimiento").notNull().getProperty();
		prestamo.addToMany(detallePrestamo, prestamoToDetallePrestamo,
				"movimientos");
		movimiento.addToMany(detallePrestamo, movimientoToDetallePrestamo,
				"prestamos");
		detallePrestamo.addToOne(prestamo, prestamoToDetallePrestamo,
				"prestamo");
		detallePrestamo.addToOne(movimiento, prestamoToDetallePrestamo,
				"movimiento");

		Entity ajuste = esquema.addEntity("Ajuste");
		ajuste.addIdProperty().autoincrement();
		ajuste.addDateProperty("fechaHora").notNull();
		ajuste.addDoubleProperty("totalDesfasado").notNull();

		Entity detalleAjuste = esquema.addEntity("detalleAjuste");
		detalleAjuste.addIdProperty().autoincrement();
		Property ajusteToDetalleAjuste = detalleAjuste
				.addLongProperty("idAjuste").notNull().getProperty();
		Property movimientoToDetalleAjuste = detalleAjuste
				.addLongProperty("idMovimiento").notNull().getProperty();
		ajuste.addToMany(detalleAjuste, ajusteToDetalleAjuste, "movimientos");
		movimiento.addToMany(detalleAjuste, movimientoToDetalleAjuste,
				"ajustes");
		detalleAjuste.addToOne(ajuste, ajusteToDetalleAjuste, "ajuste");
		detalleAjuste.addToOne(movimiento, ajusteToDetalleAjuste, "movimiento");

		//
		// contactos.implementsInterface("Parcelable");
		// contactos.implementsInterface("IContactoTelefono");
		// contactos.addStringProperty("nombre").notNull();
		// contactos.addStringProperty("codigo_pais").notNull();
		// contactos.addStringProperty("telefono").notNull();
		// contactos.addStringProperty("muro");
		// contactos.addByteArrayProperty("foto");
		// contactos.addBooleanProperty("save_historial").notNull();
		// contactos.addBooleanProperty("mask").notNull();
		// Property idMask = contactos.addLongProperty("idMask").getProperty();
		//
		// Entity mascara = esquema.addEntity("Mascara");
		// mascara.implementsInterface("Parcelable");
		// mascara.addIdProperty().autoincrement();
		// mascara.addStringProperty("nombre").notNull();
		// mascara.addStringProperty("telefono").notNull();
		// mascara.addStringProperty("muro");
		// mascara.addByteArrayProperty("foto");
		//
		// contactos.addToOne(mascara, idMask);
		//
		// Entity mensaje = esquema.addEntity("Mensaje");
		// mensaje.implementsInterface("Parcelable");
		// mensaje.addIdProperty().autoincrement();
		// mensaje.addStringProperty("numero_asociado").notNull();
		// mensaje.addByteProperty("tipo").notNull();
		// mensaje.addByteProperty("tipo_mensaje").notNull();
		// mensaje.addStringProperty("texto").notNull();
		// mensaje.addBooleanProperty("autodestruccion").notNull();
		// mensaje.addDateProperty("fecha_hora").notNull();
		// Property idContacto = mensaje.addLongProperty("idContacto").notNull()
		// .getProperty();
		//
		// ToMany contactoToMensaje = contactos.addToMany(mensaje, idContacto);
		// contactoToMensaje.setName("mensajes");

		new DaoGenerator().generateAll(esquema,
				"C:/Users/Ernesto/git/IGBalance/BalancePersonal/src-gen");
	}

	// public static void addPerfil(Schema esquema){
	// Entity contactos = esquema.addEntity("Perfil");
	// contactos.addIdProperty().autoincrement();
	// contactos.addStringProperty("nombre").notNull();
	// contactos.addIntProperty("id_personaje");
	// contactos.addIntProperty("mejor_tiempo").notNull();
	// contactos.addIntProperty("mejor_puntaje").notNull();
	// }
}
