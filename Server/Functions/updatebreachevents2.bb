Function updatebreachevents2%()
    Local local0.events
    Local local1%
    Local local2%
    Local local4.players
    Local local5%
    For local0 = Each events
        local1 = local0\Field22
        Select local1
            Case $36
                For local4 = Each players
                    local2 = local4\Field36
                    If (local2 <> $00) Then
                        If (1.0 > (Abs ((local4\Field1 + 0.32) - entityy(local0\Field1\Field25[$0B], $01)))) Then
                            If (((((((10.0 > distance(local4\Field0, local4\Field2, entityx(local0\Field1\Field25[$0B], $01), entityz(local0\Field1\Field25[$0B], $01))) And (local2 <> ntf_model)) And (local2 <> guard_model)) And (local2 <> haos_model)) And (mp_isascp(local2) = $00)) And (multiplayer_breach_isa035(local2) = $00)) <> 0) Then
                                local5 = $00
                                If (local2 = classd_model) Then
                                    breach_givetickets($01, $0A)
                                    local5 = $01
                                    gameinfo\Field5\Field14 = (gameinfo\Field5\Field14 + $01)
                                EndIf
                                If ((((((local2 = scientist_model) Or (local2 = model_clerk)) Or (local2 = janitor_model)) Or (local2 = worker_model)) And local4\Field141) <> 0) Then
                                    breach_givetickets($01, $14)
                                    local5 = $01
                                    gameinfo\Field5\Field12 = (gameinfo\Field5\Field12 + $01)
                                EndIf
                                If (local5 <> 0) Then
                                    setplayertype(local4\Field30, haos_model)
                                    If (getscripts() <> 0) Then
                                        public_inqueue($2B, $00)
                                        public_addparam($00, (Str local4\Field30), $01)
                                        public_addparam($00, (Str local2), $01)
                                        public_addparam($00, (Str local4\Field75), $01)
                                        callback($00)
                                    EndIf
                                Else
                                    setplayertype(local4\Field30, $00)
                                    If (getscripts() <> 0) Then
                                        public_inqueue($2C, $00)
                                        public_addparam($00, (Str local4\Field30), $01)
                                        public_addparam($00, (Str local2), $01)
                                        public_addparam($00, (Str local4\Field75), $01)
                                        callback($00)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Next
            Case $37
                local0\Field1\Field29[$03]\Field5 = $01
                For local4 = Each players
                    local2 = local4\Field36
                    If (local2 <> $00) Then
                        If (4.0 > entitydistance(local0\Field1\Field25[$1B], local4\Field64)) Then
                            If ((((((local2 <> ntf_model) And (local2 <> guard_model)) And (local2 <> haos_model)) And (mp_isascp(local2) = $00)) And (multiplayer_breach_isa035(local2) = $00)) <> 0) Then
                                local5 = $00
                                If (((((local2 = scientist_model) Or (local2 = model_clerk)) Or (local2 = janitor_model)) Or (local2 = worker_model)) <> 0) Then
                                    breach_givetickets($00, $0A)
                                    local5 = $01
                                    gameinfo\Field5\Field15 = (gameinfo\Field5\Field15 + $01)
                                EndIf
                                If (((local2 = classd_model) And local4\Field141) <> 0) Then
                                    breach_givetickets($00, $14)
                                    local5 = $01
                                    gameinfo\Field5\Field13 = (gameinfo\Field5\Field13 + $01)
                                EndIf
                                If (local5 <> 0) Then
                                    setplayertype(local4\Field30, ntf_model)
                                    If (getscripts() <> 0) Then
                                        public_inqueue($2B, $00)
                                        public_addparam($00, (Str local4\Field30), $01)
                                        public_addparam($00, (Str local2), $01)
                                        public_addparam($00, (Str local4\Field75), $01)
                                        callback($00)
                                    EndIf
                                Else
                                    setplayertype(local4\Field30, $00)
                                    If (getscripts() <> 0) Then
                                        public_inqueue($2C, $00)
                                        public_addparam($00, (Str local4\Field30), $01)
                                        public_addparam($00, (Str local2), $01)
                                        public_addparam($00, (Str local4\Field75), $01)
                                        callback($00)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Next
        End Select
    Next
    Return $00
End Function
