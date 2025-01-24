Function mp_getsoundhandle%(arg0.mp_sound)
    If (arg0 = Null) Then
        Return $00
    EndIf
    Return arg0\Field1
    Return $00
End Function
