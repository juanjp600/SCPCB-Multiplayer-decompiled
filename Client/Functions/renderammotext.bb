Function renderammotext%()
    If (eqquipedgun <> Null) Then
        If (0.0 < ammotimer) Then
            color($FF, $FF, $FF)
            aasetfont(font3)
            aatext((Int ((Float (graphicwidth - aastringwidth((((Str eqquipedgun\Field1) + " / ") + (Str eqquipedgun\Field18))))) - (50.0 * menuscale))), (Int ((Float graphicheight) - (70.0 * menuscale))), (((Str eqquipedgun\Field1) + " / ") + (Str eqquipedgun\Field18)), $01, $00, (min((ammotimer / 2.0), 255.0) / 255.0))
            ammotimer = (ammotimer - fpsfactor)
        EndIf
    EndIf
    Return $00
End Function
