Function mp_sendblinktimer%(arg0%, arg1%)
    udp_writebyte($76)
    udp_writebyte($01)
    udp_writebyte(arg1)
    udp_sendmessage(arg0)
    player[arg0]\Field17 = (Float arg1)
    Return $00
End Function
