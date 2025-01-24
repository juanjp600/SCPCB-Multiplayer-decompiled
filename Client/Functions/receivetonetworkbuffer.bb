Function receivetonetworkbuffer%(arg0%, arg1.mp_netbuffer)
    arg1\Field2 = readavail(arg0)
    If (arg1\Field2 > banksize(arg1\Field0)) Then
        Return $00
    EndIf
    readbytes(arg1\Field0, arg0, $00, arg1\Field2)
    mp_flushreadbuffer(arg1)
    Return $01
    Return $00
End Function
