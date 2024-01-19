Function updatelever%(arg0%, arg1%)
    Local local0#
    entitypickmode(arg0, $00, $01)
    local0 = entitydistance(camera, arg0)
    If (0.0 < entitypitch(arg0, $01)) Then
        Return $01
    Else
        Return $00
    EndIf
    Return $00
End Function
