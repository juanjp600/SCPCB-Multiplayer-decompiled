Function mp_client_itemaction_use%(arg0.items, arg1.items)
    If ((mp_ishoster() Lor (mp_getsocket() = $00)) <> 0) Then
        Return $00
    EndIf
    mp_writebyte($08)
    mp_writebyte(mp_getmyindex())
    mp_writebyte($01)
    mp_writeshort(arg0\Field19)
    If (arg1 <> Null) Then
        mp_writeshort(arg1\Field19)
    Else
        mp_writeshort($00)
    EndIf
    mp_writebyte(is1162touch)
    mp_sendtoserver()
    Return $00
End Function
