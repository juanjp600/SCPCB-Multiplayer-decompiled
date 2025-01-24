Function mp_waitingforping%(arg0%)
    mp_ping\Field2 = (mp_gettimer() + arg0)
    Return $00
End Function
