package Utils.PlaceHolders;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

/**
 * 
 * @author Katering Osorto
 */

/**
 * La clase TextPrompt mostrará un mensaje sobre un componente 
 * de texto cuando el documento del campo de texto esté vacío. 
 * La propiedad Mostrar se utiliza para determinar la visibilidad de la solicitud.
 * 
 * La fuente y el color de primer plano de la solicitud se establecerán de forma 
 * predeterminada en esas propiedades del componente de texto principal. 
 * Eres libre de cambiar las propiedades después de la construcción de la clase.
 */
public class TextPrompt extends JLabel implements FocusListener, DocumentListener {

	private static final long serialVersionUID = 1L;

	public enum Show 
        {
            ALWAYS, FOCUS_GAINED, FOCUS_LOST;
	}

	private JTextComponent component;
	private Document document;

	private Show show;
	private boolean showPromptOnce;
	private int focusLost;

	public TextPrompt(String text, JTextComponent component) 
        {
            this(text, component, Show.ALWAYS);
	}

	public TextPrompt(String text, JTextComponent component, Show show) 
        {
            this.component = component;
            setShow(show);
            document = component.getDocument();

            setText(text);
            setFont(component.getFont());

            //setForeground(component.getForeground());
            setForeground(Color.gray);
            //setBorder(new EmptyBorder(component.getInsets()));
            setHorizontalAlignment(JLabel.LEADING);

            component.addFocusListener(this);
            document.addDocumentListener(this);

            component.setLayout(new BorderLayout());
            component.add(this);
            checkForPrompt();
	}

	/**
	 * Método de conveniencia para cambiar el valor alfa 
         * del color de primer plano actual al valor específico.
	 *
	 * @param alpha float
	 * valor en el rango de 0 - 1.0.
	 */
	public void changeAlpha(float alpha) 
        {
            changeAlpha((int) (alpha * 255));
	}

	/**
	 * Método de conveniencia para cambiar el valor alfa 
         * del color de primer plano actual al valor específico.
	 *
	 * @param alpha in
	 * valor en el rango de 0 - 255.
	 */
	public void changeAlpha(int alpha) 
        {
            alpha = alpha > 255 ? 255 : alpha < 0 ? 0 : alpha;

            Color foreground = getForeground();
            int red = foreground.getRed();
            int green = foreground.getGreen();
            int blue = foreground.getBlue();

            Color withAlpha = new Color(red, green, blue, alpha);
            super.setForeground(withAlpha);
	}

	/**
	 * Método de conveniencia para cambiar el estilo de la fuente actual. 
         * Los valores de estilo se encuentran en la clase Font. 
         * Los valores comunes pueden ser: Font.BOLD, Font.ITALIC 
         * y Font.BOLD + Font.ITALIC.
	 *
	 * @param style int
	 *  valor que representa el nuevo estilo de la fuente.
	 */
	public void changeStyle(int style) 
        {
            setFont(getFont().deriveFont(style));
	}

	/**
	 * Obtener la propiedad Show
	 *
	 * @return la propiedad Show
	 */
	public Show getShow() 
        {
            return show;
	}

	/**
	 * Establezca la propiedad Mostrar mensaje para controlar 
         * cuándo se muestra el mensaje. Los valores válidos son: 
         * 
         * Show.AWLAYS (predeterminado): muestra siempre el mensaje 
         * Show.Focus_GAINED: muestra el mensaje cuando el componente 
         * gana foco (y oculta el mensaje cuando se pierde el foco). 
         * Show.Focus_LOST: muestra el mensaje cuando el componente pierde el foco 
         * (y oculta el mensaje cuando se gana el enfoque).
	 *
	 * @param show Show
	 * una enumeración de Show válida.
	 */
	public void setShow(Show show) 
        {
            this.show = show;
	}
        
        /**
	 * Obtener la propiedad showPromptOnce
	 *
	 * @return la propiedad showPromptOnce
	 */
	public boolean getShowPromptOnce() 
        {
            return showPromptOnce;
	}

	/**
	 * Muestre el mensaje una vez. Una vez que el componente haya 
         * ganado / perdido el foco una vez, el mensaje no se volverá a mostrar.
	 *
	 * @param showPromptOnce boolean
	 * Cuando es verdadero, el mensaje solo se mostrará una vez; 
         * de lo contrario, se mostrará repetidamente.
	 */
	public void setShowPromptOnce(boolean showPromptOnce) 
        {
            this.showPromptOnce = showPromptOnce;
	}

	/**
	 * Compruebe si el mensaje debe estar visible o no. 
         * La visibilidad cambiará con las actualizaciones 
         * del Documento y con los cambios de enfoque.
	 */
	private void checkForPrompt() 
        {
            // Se ha introducido texto, elimine el mensaje

            if (document.getLength() > 0) 
            {
                setVisible(false);
                return;
            }

            // El mensaje ya se ha mostrado una vez, elimínelo

            if (showPromptOnce && focusLost > 0) 
            {
                setVisible(false);
                return;
            }

            /**
             * Compruebe la propiedad Mostrar y el foco del componente
             * para determinar si se debe mostrar el mensaje.
             */

            if (component.hasFocus()) 
            {
                if (show == Show.ALWAYS || show == Show.FOCUS_GAINED)
                    setVisible(true);
                else
                    setVisible(false);
            } 
            else 
            {
                if (show == Show.ALWAYS || show == Show.FOCUS_LOST)
                        setVisible(true);
                else
                        setVisible(false);
            }
	}

	// Implementar FocusListener
	public void focusGained(FocusEvent e) 
        {
            checkForPrompt();
	}

	public void focusLost(FocusEvent e) 
        {
            focusLost++;
            checkForPrompt();
	}

	// Implementar DocumentListener

	public void insertUpdate(DocumentEvent e) 
        {
            checkForPrompt();
	}

	public void removeUpdate(DocumentEvent e) 
        {
            checkForPrompt();
	}

	public void changedUpdate(DocumentEvent e) 
        {
            
	}
}