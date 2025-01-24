Function mp_dropitem%(arg0.items)
    arg0\Field24 = $00
    arg0\Field27 = $00
    arg0\Field15 = $00
    arg0\Field31 = 70.0
    mp_assignitem(arg0, Null)
    mp_client_itemaction_drop(arg0)
    Return $00
End Function
