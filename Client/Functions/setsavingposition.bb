Function setsavingposition%(arg0$, arg1#, arg2#, arg3#, arg4#)
    saveposx = arg1
    saveposy = arg2
    saveposz = arg3
    saveposa = arg4
    saveroom = arg0
    If (udp_getstream() <> 0) Then
        udp_bytestreamwritechar($78)
        If (iscoopmode() <> 0) Then
            udp_writebyte(networkserver\Field20)
            udp_sendmessage($00)
        EndIf
    EndIf
    Return $00
End Function
