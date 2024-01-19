Function usedoor%(arg0.doors, arg1%, arg2%, arg3%, arg4%)
    Local local0.itemtemplates
    Local local1%
    Local local2%
    Local local3%
    Local local6%
    local1 = $00
    If (isvalidplayer(arg3) <> 0) Then
        If (player[arg3] <> Null) Then
            If (((arg4 > $00) And (arg4 < $3E8)) <> 0) Then
                If (m_item[arg4] <> Null) Then
                    If (m_item[arg4]\Field22 = arg3) Then
                        local0 = m_item[arg4]\Field3
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    If (arg0\Field12 > $00) Then
        If (local0 = Null) Then
            If (arg1 = $01) Then
                If ((((instr((Str local2), "The keycard", $01) = $00) And (instr((Str local2), "A keycard with", $01) = $00)) Or (local3 < $D2)) <> 0) Then
                    local2 = $00
                    local3 = $1EA
                EndIf
            EndIf
            Return $00
        Else
            Select local0\Field2
                Case "key1"
                    local1 = $01
                Case "key2"
                    local1 = $02
                Case "key3"
                    local1 = $03
                Case "key4"
                    local1 = $04
                Case "key5"
                    local1 = $05
                Case "key6"
                    local1 = $06
                Default
                    local1 = $FFFFFFFF
            End Select
            local0 = Null
            If (local1 = $FFFFFFFF) Then
                If (arg1 = $01) Then
                    If ((((instr((Str local2), "The keycard", $01) = $00) And (instr((Str local2), "A keycard with", $01) = $00)) Or (local3 < $D2)) <> 0) Then
                        local2 = $00
                        local3 = $1EA
                    EndIf
                EndIf
                Return $00
            ElseIf (local1 >= arg0\Field12) Then
                If (arg1 = $01) Then
                    If (arg0\Field4 <> 0) Then
                        local2 = $00
                        local3 = $1EA
                        Return $00
                    Else
                        local2 = $00
                        local3 = $1EA
                    EndIf
                EndIf
            Else
                If (arg1 = $01) Then
                    If (arg0\Field4 <> 0) Then
                        local2 = $00
                    Else
                        local2 = (Int (("A keycard with security clearance " + (Str arg0\Field12)) + " or higher is required to operate this door."))
                    EndIf
                    local3 = $1EA
                EndIf
                Return $00
            EndIf
        EndIf
    ElseIf (arg0\Field12 < $00) Then
        If (local0 <> Null) Then
            local1 = (((local0\Field2 = "hand") And (arg0\Field12 = $FFFFFFFF)) Or ((local0\Field2 = "hand2") And (arg0\Field12 = $FFFFFFFE)))
        EndIf
        If (local1 <> $00) Then
            If (((instr((Str local2), "You placed your", $01) = $00) Or (local3 < $D2)) <> 0) Then
                local2 = (Int ((("You place the palm of the hand onto the scanner. The scanner reads: " + chr($22)) + "DNA verified. Access granted.") + chr($22)))
            EndIf
            local3 = $2BC
            local0 = Null
        Else
            If (arg1 = $01) Then
                local2 = (Int ((("You placed your palm onto the scanner. The scanner reads: " + chr($22)) + "DNA does not match known sample. Access denied.") + chr($22)))
                local3 = $2BC
            EndIf
            Return $00
        EndIf
    ElseIf (arg0\Field4 <> 0) Then
        If (arg1 = $01) Then
            If ((arg0\Field23 > $00) = $00) Then
                If (playerroom\Field7\Field10 <> "room2elevator") Then
                    If (arg0\Field5 <> 0) Then
                        local2 = $00
                    Else
                        local2 = $00
                    EndIf
                Else
                    local2 = $00
                EndIf
                local3 = $15E
            ElseIf (arg0\Field23 = $01) Then
                local2 = $00
                local3 = $15E
            ElseIf (arg0\Field23 = $03) Then
                local2 = $00
                local3 = $15E
            ElseIf ((Str local2) <> "You called the elevator.") Then
                If ((((Str local2) = "You already called the elevator.") Or (local3 < $D2)) <> 0) Then
                    Select rand($0A, $01)
                        Case $01
                            local2 = $00
                            local3 = $1EA
                        Case $02
                            local2 = $00
                            local3 = $1EA
                        Case $03
                            local2 = $00
                            local3 = $1EA
                        Default
                            local2 = $00
                            local3 = $1EA
                    End Select
                EndIf
            Else
                local2 = $00
                local3 = $1EA
            EndIf
        EndIf
        Return $00
    EndIf
    arg0\Field5 = (arg0\Field5 = $00)
    If (arg0\Field22 <> Null) Then
        arg0\Field22\Field5 = (arg0\Field22\Field5 = $00)
    EndIf
    local6 = $00
    If (arg0\Field9 = $01) Then
        local6 = rand($00, $01)
    Else
        local6 = rand($00, $02)
    EndIf
    If (arg2 = $01) Then
        If (arg0\Field5 <> 0) Then
            If (arg0\Field22 <> Null) Then
                arg0\Field22\Field11 = (Float arg0\Field22\Field10)
            EndIf
            arg0\Field11 = (Float arg0\Field10)
        EndIf
    ElseIf (arg0\Field5 <> 0) Then
        If (arg0\Field22 <> Null) Then
            arg0\Field22\Field11 = (Float arg0\Field22\Field10)
        EndIf
        arg0\Field11 = (Float arg0\Field10)
    EndIf
    Return $00
End Function
