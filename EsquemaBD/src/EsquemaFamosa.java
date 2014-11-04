import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class EsquemaFamosa {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Schema confing = new Schema(1, "tsmbo.famosa.marcacion.entidades");
		confing.setDefaultJavaPackageDao("tsmbo.famosa.marcacion.daos_config");
		confing.enableKeepSectionsByDefault();

		Entity config = confing.addEntity("Configuracion");
		config.addIdProperty().autoincrement();
		config.addStringProperty("key").notNull();
		config.addStringProperty("value").notNull();

		new DaoGenerator()
				.generateAll(
						confing,
						"F:/Documentos/proyectos externos/BalancePersonal/workspace/Marcacion/src");

		Schema esquema = new Schema(1, "tsmbo.famosa.marcacion.entidades");
		esquema.setDefaultJavaPackageDao("tsmbo.famosa.marcacion.daos");
		esquema.enableKeepSectionsByDefault();

		// Entity funcionario = esquema.addEntity("Funcionario");
		// funcionario.addLongProperty("nroRegistro").notNull();
		// funcionario.addStringProperty("nombre").notNull();
		// funcionario.addStringProperty("descripcionHorario").notNull();
		// funcionario.addIntProperty("codHorario").notNull();
		// funcionario.addIntProperty("maxAdelanto").notNull();
		// funcionario.addIntProperty("maxAtraso").notNull();
		//
		// Entity dia = esquema.addEntity("Dia");
		// dia.addIdProperty().notNull();
		// dia.addStringProperty("descripcion").notNull();
		//
		// Entity turno = esquema.addEntity("Turno");
		// turno.addIdProperty().notNull();
		// turno.addStringProperty("descripcion").notNull();
		// turno.addStringProperty("horaIngreso").notNull();
		// turno.addStringProperty("horaSalida").notNull();
		// Property idDia = turno.addLongProperty("idDia").getProperty();

		Entity zonaTrabajo = esquema.addEntity("ZonaTrabajo");
		zonaTrabajo.addIdProperty().primaryKey();
		zonaTrabajo.addStringProperty("nombre").notNull();
		zonaTrabajo.addDoubleProperty("latitud").notNull();
		zonaTrabajo.addDoubleProperty("longitud").notNull();
		zonaTrabajo.addStringProperty("sigla").notNull();
		zonaTrabajo.addDoubleProperty("rango").notNull();
		zonaTrabajo.addIntProperty("estado").notNull();
		
		Entity servicio = esquema.addEntity("Servicio");
		servicio.addIdProperty().primaryKey();
		servicio.addStringProperty("nombre").notNull();
		servicio.addIntProperty("estado").notNull();

		Entity marcacion = esquema.addEntity("Marcacion");
		marcacion.implementsInterface("Parcelable");
		marcacion.addIdProperty().autoincrement();
		marcacion.addIntProperty("codHorario").notNull();
		marcacion.addIntProperty("idFuncionario").notNull();
		marcacion.addByteProperty("tipoMarcacion").notNull();
		marcacion.addStringProperty("imeiDispositivo").notNull();
		marcacion.addStringProperty("fechaHora").notNull();
		marcacion.addIntProperty("idZona").notNull();
		marcacion.addIntProperty("idTurno").notNull();
		marcacion.addIntProperty("imei");
		marcacion.addStringProperty("siglaZona").notNull();
		marcacion.addDoubleProperty("latitud").notNull();
		marcacion.addDoubleProperty("longitud").notNull();
		marcacion.addFloatProperty("precision").notNull();
		marcacion.addByteProperty("status").notNull();
		marcacion.addStringProperty("observacion");
		marcacion.addBooleanProperty("enviado").notNull();
		// Property idMarcacionInicialMarcacion = marcacion.addLongProperty(
		// "idMarcacionInicial").getProperty();
		// marcacion.addToOne(marcacion, idMarcacionInicialMarcacion,
		// "marcacionInicial");

		Entity tracking = esquema.addEntity("Tracking");
		tracking.addIdProperty().autoincrement();
		tracking.addIntProperty("idFuncionario").notNull();
		tracking.addStringProperty("imeiDispositivo").notNull();
		tracking.addStringProperty("fechaHora").notNull();
		tracking.addLongProperty("idZona").notNull();
		tracking.addDoubleProperty("latitud").notNull();
		tracking.addDoubleProperty("longitud").notNull();
		tracking.addFloatProperty("precision").notNull();
		tracking.addStringProperty("imei");
		tracking.addBooleanProperty("enviado").notNull();
		// Property idMarcacionInicialTracking = tracking.addLongProperty(
		// "idMarcacionInicial").getProperty();

		// ToMany DiaATurno = dia.addToMany(turno, idDia);
		// DiaATurno.setName("turnos");
		// turno.addToOne(dia, idDia);

		// ToMany MarcacionATracking = marcacion.addToMany(tracking,
		// idMarcacionInicialTracking);
		// MarcacionATracking.setName("trackings");
		// tracking.addToOne(marcacion, idMarcacionInicialTracking);
		
//		Entity solicitud = esquema.addEntity("Solicitud");
//		solicitud.addIdProperty();
//		solicitud.

		new DaoGenerator()
				.generateAll(
						esquema,
						"F:/Documentos/proyectos externos/BalancePersonal/workspace/Marcacion/src");
	}
}
