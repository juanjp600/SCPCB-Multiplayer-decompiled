Function blitz_mp_readbyte0%(arg0.mp_netbuffer)
    If ((arg0\Field1 + $01) > arg0\Field2) Then
        Return $00
    EndIf
    arg0\Field1 = (arg0\Field1 + $01)
    Return peekbyte(arg0\Field0, (arg0\Field1 - $01))
    Return $00
End Function
