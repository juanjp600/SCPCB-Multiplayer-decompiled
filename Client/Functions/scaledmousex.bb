Function scaledmousex%()
    Return (Int ((((Float mousex()) - (((Float realgraphicwidth) * 0.5) * (1.0 - aspectratioratio))) * (Float graphicwidth)) / ((Float realgraphicwidth) * aspectratioratio)))
    Return $00
End Function
