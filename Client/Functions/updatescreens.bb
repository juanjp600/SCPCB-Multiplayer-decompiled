Function updatescreens%()
    Local local0.screens
    If ((((((invopen Lor i_294\Field0) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor (selectedscreen <> Null)) Lor (0.3 >= secondarylighton)) <> 0) Then
        Return $00
    EndIf
    For local0 = Each screens
        If (local0\Field3 = playerroom) Then
            If (interactobject(local0\Field0, 1.0, $02) <> 0) Then
                selectedscreen = local0
                local0\Field2 = scaleimageex(loadimage_strict(("GFX\Map\Screens\" + local0\Field1)), menuscale, menuscale, $01)
                playsound_strict(buttonsfx[$00], $00, $01)
                mo\Field6 = $00
                Exit
            EndIf
        EndIf
    Next
    Return $00
End Function
