Function mp_server_itemaction%(arg0.mp_player, arg1%)
    Select arg1
        Case $03
            mp_server_itemaction_drop(arg0, mp_readshort())
        Case $02
            mp_server_itemaction_take(arg0, mp_readshort())
        Case $01
            mp_server_itemaction_use(arg0)
        Case $04
            mp_server_itemaction_assigning(arg0)
    End Select
    Return $00
End Function
