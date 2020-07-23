package com.jobs.view;

import java.util.List;

import com.jobs.application.JobsController;
import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Volunteer;

/*Una empresa ens demana desenvolupar un software per gestionar el sous del seus empleats. 
 * LINK PROJECTE: Projecte polimorfisme
 * El sistema de pagament dependrà de l’empleat. Hi ha quatre tipus:
 * - Manager: cobren un 10% més del seu salari mensual.
 * - Boss: cobren un 50% més del seu salari mensual.
 * - Employee: cobren el sou mensual aplicant una reducció del 15%
 * - Volunteer: no cobren
 * S’ha de partir del projecte parcialment desenvolupat i acabar les funcionalitats pendents de programar
 * per tal que el software funcioni correctament.*/

public class Main {

	private static JobsController controller = new JobsController();

	public static void main(String[] args) throws Exception {

		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 80.0);

		controller.payAllEmployeers();

		List<AbsStaffMember> allEmployees = controller.getAllEmployees();

		for (AbsStaffMember a : allEmployees) {

			if (a instanceof Volunteer) {
				System.out.println("EMPLOYEES: " + a.getId() + " | " + a.getName() + " | " + a.getAddress() + " | "
						+ a.getPhone() + " | " + ((Volunteer) a).getDescription() + " | ");
			} else {
				System.out.println("EMPLOYEES: " + a.getId() + " | " + a.getName() + " | " + a.getAddress() + " | "
						+ a.getPhone() + " | " + a.getTotalPaid() + " | ");
			}
		}
	}
}
