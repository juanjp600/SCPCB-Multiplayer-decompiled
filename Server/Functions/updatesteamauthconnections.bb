Function updatesteamauthconnections%()
    Local local0.authconnection
    Local local1%
    Local local2.centralserversegments
    Local local3%
    For local0 = Each authconnection
        If ((local0\Field8 - $5DC) < millisecs()) Then
            If (local0\Field11 = $00) Then
                If (local0\Field10 > $00) Then
                    If (getscripts() <> 0) Then
                        public_inqueue($42, $00)
                        public_addparam($00, local0\Field2, $03)
                        public_addparam($00, dottedip(local0\Field0), $03)
                        public_addparam($00, (Str local0\Field7), $01)
                        public_addparam($00, local0\Field3, $03)
                        public_addparam($00, (Str local0\Field6), $01)
                        public_addparam($00, "-1", $01)
                        callback($00)
                    EndIf
                    If (((se_getreturnvalue() = "-1") Or (se_getreturnvalue() > "0")) <> 0) Then
                        addlog(((((local0\Field2 + " bad authorization ticket [") + (Str local0\Field10)) + "]: ") + dottedip(local0\Field0)), $00, $00, $00)
                    EndIf
                    sendserverdatatoplayer(local0\Field0, local0\Field1)
                    local0\Field11 = $01
                Else
                    If (((se_getreturnvalue() = "-1") Or (se_getreturnvalue() > "0")) <> 0) Then
                        addlog(((local0\Field2 + " bad authorization ticket [Central server time out]: ") + dottedip(local0\Field0)), $00, $00, $00)
                    EndIf
                    removeauthconnection(local0)
                EndIf
            EndIf
        EndIf
        If (local0\Field8 < millisecs()) Then
            removeauthconnection(local0)
        EndIf
    Next
    Repeat
        local1 = recvudpmsg(centralserver\Field1)
        If (local1 <> $00) Then
            For local2 = Each centralserversegments
                If (local1 = local2\Field2) Then
                    local3 = readbyte(centralserver\Field1)
                    If (local3 = $02) Then
                        local0 = (Object.authconnection readint(centralserver\Field1))
                        If (local0 <> Null) Then
                            If (local0\Field11 = $00) Then
                                local0\Field10 = readbyte(centralserver\Field1)
                                If (local0\Field10 = $00) Then
                                    local0\Field11 = $01
                                    sendserverdatatoplayer(local0\Field0, local0\Field1)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    Exit
                EndIf
            Next
        Else
            Exit
        EndIf
    Forever
    Return $00
End Function
