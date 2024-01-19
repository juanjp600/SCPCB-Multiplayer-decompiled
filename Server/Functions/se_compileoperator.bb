Function se_compileoperator.se_vf_value(arg0.se_node)
    Local local0.se_token
    Local local1%
    Local local2%
    Local local3.se_vf_label
    Local local4.se_vf_value
    Local local5.se_vf_value
    Local local6%
    Local local7.se_vf_value
    Local local8.se_vf_value
    Local local9.se_vf_value
    local0 = arg0\Field0
    local1 = $01
    Repeat
        local7 = Null
        local8 = Null
        local9 = Null
        If (arg0\Field8 <> Null) Then
            If (((arg0\Field8\Field1 = $05) Or (arg0\Field8\Field1 = $06)) <> 0) Then
                local2 = $01
            EndIf
        Else
            local2 = $01
        EndIf
        Select local0\Field1
            Case "="
                local7 = se_compilenode(arg0\Field4[$00])
                local8 = se_compilenode(arg0\Field4[$01])
                If (local8 = Null) Then
                    local8 = se_poptemp()
                EndIf
                If (local7 = Null) Then
                    local7 = se_poptemp()
                EndIf
                se_vf_createinst($01, local7, local8, Null)
                Return local7
            Case "+"
                If (local1 <> 0) Then
                    local1 = $00
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    local7 = se_poptemp()
                EndIf
                local9 = se_pushtemp()
                se_vf_createinst($02, local7, local8, local9)
            Case "-"
                If (arg0\Field2 = $06) Then
                    local7 = se_compilenode(arg0\Field4[$01])
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                    local8 = se_pushtemp()
                    se_vf_createinst($08, local7, local8, Null)
                    Return local8
                Else
                    If (local1 <> 0) Then
                        local1 = $00
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                    Else
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        local7 = se_poptemp()
                    EndIf
                    local9 = se_pushtemp()
                    se_vf_createinst($03, local7, local8, local9)
                EndIf
            Case "*"
                If (arg0\Field2 = $03) Then
                    local7 = se_getvariable(arg0\Field4[$01]\Field0\Field1)
                    local8 = se_pushtemp()
                    se_vf_createinst($20, local7, local8, Null)
                    Return local8
                Else
                    If (local1 <> 0) Then
                        local1 = $00
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                    Else
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        local7 = se_poptemp()
                    EndIf
                    local9 = se_pushtemp()
                    se_vf_createinst($04, local7, local8, local9)
                EndIf
            Case "/"
                If (local1 <> 0) Then
                    local1 = $00
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    local7 = se_poptemp()
                EndIf
                local9 = se_pushtemp()
                se_vf_createinst($05, local7, local8, local9)
            Case "**"
                If (local1 <> 0) Then
                    local1 = $00
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    local7 = se_poptemp()
                EndIf
                local9 = se_pushtemp()
                se_vf_createinst($06, local7, local8, local9)
            Case "%"
                If (local1 <> 0) Then
                    local1 = $00
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    local7 = se_poptemp()
                EndIf
                local9 = se_pushtemp()
                se_vf_createinst($07, local7, local8, local9)
            Case "++"
                If (arg0\Field4[$00] <> Null) Then
                    local7 = se_pushtemp()
                    local8 = se_compilenode(arg0\Field4[$00])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    se_vf_createinst($01, local7, local8, Null)
                    se_vf_createinst($09, local8, Null, Null)
                    se_poptemp()
                    Return local7
                Else
                    local7 = se_compilenode(arg0\Field4[$01])
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                    se_vf_createinst($09, local7, Null, Null)
                    Return local7
                EndIf
            Case "--"
                If (arg0\Field4[$00] <> Null) Then
                    local7 = se_pushtemp()
                    local8 = se_compilenode(arg0\Field4[$00])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    se_vf_createinst($01, local7, local8, Null)
                    se_vf_createinst($0A, local8, Null, Null)
                    Return local7
                Else
                    local7 = se_compilenode(arg0\Field4[$01])
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                    se_vf_createinst($0A, local7, Null, Null)
                    Return local7
                EndIf
            Case "=="
                If (local1 <> 0) Then
                    local1 = $00
                    If (local2 = $00) Then
                        local3 = se_vf_createlabel()
                        local4 = se_pushtemp()
                        local5 = se_pushtemp()
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        se_vf_createinst($0B, local7, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        local9 = se_pushtemp()
                        se_vf_createinst($0B, local7, local8, local9)
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local2 = $00) Then
                        se_vf_createinst($0B, local5, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local3\Field1 = se_vf_createinst($0B, local5, local8, local4)
                        local3\Field2 = $01
                        se_poptemp()
                    EndIf
                EndIf
            Case "!="
                If (local1 <> 0) Then
                    local1 = $00
                    If (local2 = $00) Then
                        local3 = se_vf_createlabel()
                        local4 = se_pushtemp()
                        local5 = se_pushtemp()
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        se_vf_createinst($0C, local7, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        local9 = se_pushtemp()
                        se_vf_createinst($0C, local7, local8, local9)
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local2 = $00) Then
                        se_vf_createinst($0C, local5, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local3\Field1 = se_vf_createinst($0C, local5, local8, local4)
                        local3\Field2 = $01
                        se_poptemp()
                    EndIf
                EndIf
            Case ">"
                If (local1 <> 0) Then
                    local1 = $00
                    If (local2 = $00) Then
                        local3 = se_vf_createlabel()
                        local4 = se_pushtemp()
                        local5 = se_pushtemp()
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        se_vf_createinst($0D, local7, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        local9 = se_pushtemp()
                        se_vf_createinst($0D, local7, local8, local9)
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local2 = $00) Then
                        se_vf_createinst($0D, local5, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local3\Field1 = se_vf_createinst($0D, local5, local8, local4)
                        local3\Field2 = $01
                        se_poptemp()
                    EndIf
                EndIf
            Case "<"
                If (local1 <> 0) Then
                    local1 = $00
                    If (local2 = $00) Then
                        local3 = se_vf_createlabel()
                        local4 = se_pushtemp()
                        local5 = se_pushtemp()
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        se_vf_createinst($0E, local7, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        local9 = se_pushtemp()
                        se_vf_createinst($0E, local7, local8, local9)
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local2 = $00) Then
                        se_vf_createinst($0E, local5, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local3\Field1 = se_vf_createinst($0E, local5, local8, local4)
                        local3\Field2 = $01
                        se_poptemp()
                    EndIf
                EndIf
            Case ">="
                If (local1 <> 0) Then
                    local1 = $00
                    If (local2 = $00) Then
                        local3 = se_vf_createlabel()
                        local4 = se_pushtemp()
                        local5 = se_pushtemp()
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        se_vf_createinst($0F, local7, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        local9 = se_pushtemp()
                        se_vf_createinst($0F, local7, local8, local9)
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local2 = $00) Then
                        se_vf_createinst($0F, local5, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local3\Field1 = se_vf_createinst($0F, local5, local8, local4)
                        local3\Field2 = $01
                        se_poptemp()
                    EndIf
                EndIf
            Case "<="
                If (local1 <> 0) Then
                    local1 = $00
                    If (local2 = $00) Then
                        local3 = se_vf_createlabel()
                        local4 = se_pushtemp()
                        local5 = se_pushtemp()
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        se_vf_createinst($10, local7, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local7 = se_compilenode(arg0\Field4[$00])
                        local8 = se_compilenode(arg0\Field4[$01])
                        If (local8 = Null) Then
                            local8 = se_poptemp()
                        EndIf
                        If (local7 = Null) Then
                            local7 = se_poptemp()
                        EndIf
                        local9 = se_pushtemp()
                        se_vf_createinst($10, local7, local8, local9)
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local2 = $00) Then
                        se_vf_createinst($10, local5, local8, local4)
                        se_vf_createinst($1A, local4, se_vf_getlabel(local3), Null)
                        se_vf_createinst($01, local5, local8, Null)
                    Else
                        local3\Field1 = se_vf_createinst($10, local5, local8, local4)
                        local3\Field2 = $01
                        se_poptemp()
                    EndIf
                EndIf
            Case "&"
                If (local1 <> 0) Then
                    local1 = $00
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    local7 = se_poptemp()
                EndIf
                local9 = se_pushtemp()
                se_vf_createinst($11, local7, local8, local9)
            Case "&"
                If (local1 <> 0) Then
                    local1 = $00
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    local7 = se_poptemp()
                EndIf
                local9 = se_pushtemp()
                se_vf_createinst($11, local7, local8, local9)
            Case "^"
                If (local1 <> 0) Then
                    local1 = $00
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    local7 = se_poptemp()
                EndIf
                local9 = se_pushtemp()
                se_vf_createinst($12, local7, local8, local9)
            Case "|"
                If (local1 <> 0) Then
                    local1 = $00
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    local7 = se_poptemp()
                EndIf
                local9 = se_pushtemp()
                se_vf_createinst($13, local7, local8, local9)
            Case "~"
                local7 = se_compilenode(arg0\Field4[$01])
                If (local7 = Null) Then
                    local7 = se_poptemp()
                EndIf
                local8 = se_pushtemp()
                se_vf_createinst($14, local7, local8, Null)
                Return local8
            Case "<<"
                If (local1 <> 0) Then
                    local1 = $00
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    local7 = se_poptemp()
                EndIf
                local9 = se_pushtemp()
                se_vf_createinst($15, local7, local8, local9)
            Case ">>"
                If (local1 <> 0) Then
                    local1 = $00
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    local7 = se_poptemp()
                EndIf
                local9 = se_pushtemp()
                se_vf_createinst($16, local7, local8, local9)
            Case "not"
                local7 = se_compilenode(arg0\Field4[$01])
                If (local7 = Null) Then
                    local7 = se_poptemp()
                EndIf
                local8 = se_pushtemp()
                se_vf_createinst($17, local7, local8, Null)
                Return local8
            Case "and"
                If (local1 <> 0) Then
                    local1 = $00
                    local3 = se_vf_createlabel()
                    local4 = se_pushtemp()
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                    se_vf_createinst($01, local4, local7, Null)
                    se_vf_createinst($1A, local7, se_vf_getlabel(local3), Null)
                    If (local2 = $00) Then
                        se_vf_createinst($01, local4, local8, Null)
                        se_vf_createinst($1A, local8, se_vf_getlabel(local3), Null)
                    Else
                        local3\Field1 = se_vf_createinst($01, local4, local8, Null)
                        local3\Field2 = $01
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local2 = $00) Then
                        se_vf_createinst($01, local4, local8, Null)
                        se_vf_createinst($1A, local8, se_vf_getlabel(local3), Null)
                    Else
                        local3\Field1 = se_vf_createinst($01, local4, local8, Null)
                        local3\Field2 = $01
                    EndIf
                EndIf
            Case "or"
                If (local1 <> 0) Then
                    local1 = $00
                    local3 = se_vf_createlabel()
                    local4 = se_pushtemp()
                    local7 = se_compilenode(arg0\Field4[$00])
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local7 = Null) Then
                        local7 = se_poptemp()
                    EndIf
                    se_vf_createinst($01, local4, local7, Null)
                    se_vf_createinst($19, local7, se_vf_getlabel(local3), Null)
                    If (local2 = $00) Then
                        se_vf_createinst($01, local4, local8, Null)
                        se_vf_createinst($19, local8, se_vf_getlabel(local3), Null)
                    Else
                        local3\Field1 = se_vf_createinst($01, local4, local8, Null)
                        local3\Field2 = $01
                    EndIf
                Else
                    local8 = se_compilenode(arg0\Field4[$01])
                    If (local8 = Null) Then
                        local8 = se_poptemp()
                    EndIf
                    If (local2 = $00) Then
                        se_vf_createinst($01, local4, local8, Null)
                        se_vf_createinst($19, local8, se_vf_getlabel(local3), Null)
                    Else
                        local3\Field1 = se_vf_createinst($01, local4, local8, Null)
                        local3\Field2 = $01
                    EndIf
                EndIf
            Case "len"
                local7 = se_compilenode(arg0\Field4[$01])
                If (local7 = Null) Then
                    local7 = se_poptemp()
                EndIf
                local8 = se_pushtemp()
                se_vf_createinst($25, local7, local8, Null)
                Return local8
            Case "typeof"
                local7 = se_compilenode(arg0\Field4[$01])
                If (local7 = Null) Then
                    local7 = se_poptemp()
                EndIf
                local8 = se_pushtemp()
                se_vf_createinst($21, local7, local8, Null)
                Return local8
            Case "args"
                local7 = se_pushtemp()
                se_vf_createinst($22, local7, Null, Null)
                Return local8
        End Select
        If (arg0\Field1 = $03) Then
            Exit
        ElseIf (arg0\Field1 = $04) Then
            arg0 = arg0\Field8
        EndIf
        If (local2 <> 0) Then
            Exit
        EndIf
        local0 = arg0\Field0
    Forever
    Return Null
End Function
