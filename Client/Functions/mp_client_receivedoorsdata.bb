Function mp_client_receivedoorsdata%()
    Local local0%
    Local local1%
    Local local2%
    Local local3.doors
    Repeat
        local0 = mp_readshort()
        If (local0 = $00) Then
            Exit
        EndIf
        local1 = mp_readbyte()
        local2 = mp_readbyte()
        local3 = mp_doors[local0]
        If (((local3 <> Null) And (0.0 >= local3\Field40)) <> 0) Then
            local3\Field4 = readbool(local1, $01)
            If (((local3\Field31 = $00) And (((local3\Field29 <> Null) And local3\Field29\Field31) = $00)) <> 0) Then
                local3\Field31 = readbool(local2, $01)
                local3\Field6 = readbool(local1, $00)
            EndIf
            local3\Field35 = readbool(local1, $05)
            If ((readbool(local1, $06) And (local3\Field27 = $00)) <> 0) Then
                affectdecaydoor(local3)
            EndIf
            If (((local3\Field10 = $01) And (local3\Field28 <> readbool(local2, $00))) <> 0) Then
                If (local3\Field28 <> 0) Then
                    clearelevatorpaneltexture(local3)
                Else
                    updateelevatorpanel(local3)
                EndIf
            EndIf
            If ((readbool(local1, $02) And (local3\Field33 = $00)) <> 0) Then
                If (0.0 < (Float animlength(local3\Field0))) Then
                    setanimtime(local3\Field0, 1.0, $00)
                    local3\Field33 = $01
                EndIf
            ElseIf ((readbool(local1, $03) And (local3\Field34 = $00)) <> 0) Then
                local3\Field34 = (readbool(local1, $04) + $01)
                If (local3\Field3[(local3\Field34 - $01)] <> $00) Then
                    setanimtime(local3\Field3[(local3\Field34 - $01)], ((((Float ((local3\Field10 = $01) Lor (local3\Field4 = $00))) * 20.0) * (Float (local3\Field35 = $00))) + 1.0), $00)
                EndIf
            EndIf
        EndIf
    Forever
    Return $00
End Function
