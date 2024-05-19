package AimsProject.src.hust.soict.globalict.aims.screen.manger;

import AimsProject.src.hust.soict.globalict.aims.media.CD;
import AimsProject.src.hust.soict.globalict.aims.media.DVD;
import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.media.Track;
import AimsProject.src.hust.soict.globalict.aims.play.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getId()+ " - " + media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            container.add(playButton);
            playButton.addActionListener(this::actionPerformed);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if (btn.equals("Play")) {

            StringBuilder output = new StringBuilder();
            if (this.media instanceof DVD) {
                if (((DVD) this.media).getLength() == 0) {
                    JOptionPane.showMessageDialog(null, "This DVD can't play!", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                } else
                    output = new StringBuilder("Playing DVD: " + this.media.getTitle() + "\n" + "Length: " + ((DVD) this.media).getLength());
            } else if (this.media instanceof CD) {
                if (((CD) this.media).getTracks().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "This CD can't play!", "Alert", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    output = new StringBuilder("Playing CD: " + this.media.getTitle() + "\n");
                    for (Track track : ((CD) this.media).getTracks()) {
                        if (track.getLength() <= 0) output.append("Track: ").append(track.getTitle()).append(" can't play!").append("\n");
                        else output.append("Playing track: ").append(track.getTitle()).append(". Track length: ").append(track.getLength()).append("\n");
                    }
                }
            }
            JOptionPane.showMessageDialog(null, output.toString(), "NOW PLAYING", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}