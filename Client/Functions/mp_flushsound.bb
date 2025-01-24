Function mp_flushsound%(arg0.mp_sound)
    If (arg0 = Null) Then
        Return $00
    EndIf
    freesound(arg0\Field1)
    arg0\Field1 = $00
    Delete arg0
    Return $00
End Function
