/*
 * This file is part of LibrePlan
 *
 * Copyright (C) 2012 Igalia, S.L.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.libreplan.web.users.dashboard;

import org.joda.time.LocalDate;
import org.libreplan.web.common.entrypoints.IURLHandlerRegistry;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;

/**
 * Controller for creation/edition of a monthly timesheet
 *
 * @author Manuel Rego Casasnovas <mrego@igalia.com>
 */
@SuppressWarnings("serial")
public class MonthlyTimesheetController extends GenericForwardComposer
        implements IMonthlyTimesheetController {

    private IMonthlyTimesheetModel monthlyTimesheetModel;

    private IURLHandlerRegistry URLHandlerRegistry;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        comp.setAttribute("controller", this);

        URLHandlerRegistry.getRedirectorFor(IMonthlyTimesheetController.class)
                .register(this, page);
    }

    @Override
    public void goToCreateOrEditForm(LocalDate date) {
        monthlyTimesheetModel.initCreateOrEdit(date);
    }

    public LocalDate getDate() {
        return monthlyTimesheetModel.getDate();
    }

}
