Function mp_sendgamedata%()
    ue_server\Field5 = (ue_server\Field5 + mp_gettimestep())
    If (1.166667 < ue_server\Field5) Then
        server_sendimportantdata()
        ue_server\Field6 = (ue_server\Field6 + $01)
        If (ue_server\Field6 > $04) Then
            ue_server\Field6 = $01
        EndIf
        Select ue_server\Field6
            Case $01
                mp_server_sendnpcsdata()
                mp_server_senditemsdata()
            Case $02
                mp_server_senddoorsdata()
            Case $03
                mp_server_sendeventsdata()
            Case $04
                ue_server\Field7 = (ue_server\Field7 + $01)
                If (ue_server\Field7 > $03) Then
                    ue_server\Field7 = $01
                EndIf
                Select ue_server\Field7
                    Case $01
                        mp_server_sendcorpsesdata()
                    Case $02
                        mp_server_sendobjectsdata($06)
                    Case $03
                        mp_server_sendobjectsdata($07)
                End Select
        End Select
        ue_server\Field5 = 0.0
    EndIf
    Return $00
End Function
