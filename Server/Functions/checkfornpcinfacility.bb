Function checkfornpcinfacility%(arg0.npcs)
    If (100.0 < entityy(arg0\Field4, $00)) Then
        Return $00
    EndIf
    If (-10.0 > entityy(arg0\Field4, $00)) Then
        Return $02
    EndIf
    If (((7.0 < entityy(arg0\Field4, $00)) And (100.0 >= entityy(arg0\Field4, $00))) <> 0) Then
        Return $02
    EndIf
    Return $01
    Return $00
End Function
