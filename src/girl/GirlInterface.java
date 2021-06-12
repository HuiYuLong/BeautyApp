package girl;

import java.awt.Graphics2D;

// Involve using decorator pattern to add at least two features //
// This interface is used for adding elements on top of the base//
// girl. (ie. blanket, pimple, smile and a dress)
public interface GirlInterface {
	void decorate(Graphics2D g2);
}
