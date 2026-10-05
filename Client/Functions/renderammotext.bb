Function renderammotext%()
    Local local0%
    Local local1%
    If (menuopen = $00) Then
        local0 = eqquipedgun\Field1
        local1 = eqquipedgun\Field18
        If ((local0 + local1) > $00) Then
            setcolorex($D2, $C8, $C8)
            text((graphicwidth - imenuscale[$96]), (graphicheight - imenuscale[$50]), (((Str local0) + " / ") + (Str local1)), $01, $01)
        EndIf
    EndIf
    Return $00
End Function
