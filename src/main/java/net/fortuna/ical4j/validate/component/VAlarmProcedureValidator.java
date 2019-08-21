package net.fortuna.ical4j.validate.component;

import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.validate.PropertyValidator;
import net.fortuna.ical4j.validate.ValidationException;
import net.fortuna.ical4j.validate.Validator;

import static net.fortuna.ical4j.model.Property.ATTACH;
import static net.fortuna.ical4j.model.Property.DESCRIPTION;

/**
 * Created by fortuna on 12/09/15.
 */
public class VAlarmProcedureValidator implements Validator<VAlarm> {

    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     */
    public void validate(VAlarm target) throws ValidationException {
        /*
         * ; the following are all REQUIRED,
         * ; but MUST NOT occur more than once action / attach / trigger /
         * ; 'duration' and 'repeat' are both optional,
         * ; and MUST NOT occur more than once each,
         * ; but if one occurs, so MUST the other duration / repeat /
         * ; 'description' is optional,
         * ; and MUST NOT occur more than once description /
         * ; the following is optional, ; and MAY occur more than once x-prop
         */
        PropertyValidator.getInstance().assertOne(ATTACH, target.getProperties());

        PropertyValidator.getInstance().assertOneOrLess(DESCRIPTION, target.getProperties());
    }
}
