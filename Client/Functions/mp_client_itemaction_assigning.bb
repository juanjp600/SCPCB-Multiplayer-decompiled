Function mp_client_itemaction_assigning%(arg0.items, arg1.items)
    If ((mp_ishoster() Lor (mp_getsocket() = $00)) <> 0) Then
        Return $00
    EndIf
    mp_writebyte($08)
    mp_writebyte(mp_getmyindex())
    mp_writebyte($04)
    mp_writeshort(arg0\Field19)
    mp_writeshort(arg1\Field19)
    mp_sendtoserver()
    Return $00
End Function
