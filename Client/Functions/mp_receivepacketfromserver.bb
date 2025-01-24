Function mp_receivepacketfromserver%()
    Local local0%
    Local local2%
    local0 = mp_readbyte()
    Select local0
        Case $05
            mp_refreshtimeout()
            myplayerlogic\Field0 = mp_readbyte()
            client_recvplayers()
            client_recvownplayerdata()
        Case $06
            local2 = mp_readbyte()
            Select local2
                Case $01
                    mp_client_receivedoorsdata()
                Case $02
                    mp_client_receiveitemsdata()
                Case $03
                    mp_client_receivenpcsdata()
                Case $04
                    mp_client_receiveeventsdata()
                Case $05
                    mp_client_receivecorpsesdata()
                Case $06
                    mp_client_receiveobjectsdata($06)
                Case $07
                    mp_client_receiveobjectsdata($07)
            End Select
        Case $09
            mp_receiverequestedinfo()
        Case $0A
            mp_client_receivevoice(ue_players[mp_readbyte()])
        Case $0B
            mp_client_receivedecal()
        Case $0C
            mp_client_receivemessage()
        Case $0F
            mp_client_receivesound()
        Case $12
            mp_client_receiveinteract(mp_readbyte())
        Case $13
            mp_client_receivechatmessage(mp_readline())
    End Select
    Return $00
End Function
