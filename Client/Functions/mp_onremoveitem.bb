Function mp_onremoveitem%(arg0.items, arg1.items)
    arg0\Field26 = $00
    If (((mp_getsocket() <> $00) And (mp_ishoster() = $00)) <> 0) Then
        mp_client_itemaction_use(arg0, arg1)
    EndIf
    Return $00
End Function
