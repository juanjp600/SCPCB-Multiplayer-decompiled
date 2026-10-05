Function se_loadscriptexec.se_script(arg0$)
    Local local0%
    Local local1.se_script
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7$
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14$
    Local local15%
    Local local16%
    Local local19$
    se_loadfilesize = filesize(arg0)
    If (((se_loadfilesize < $14) Or (se_loadfilesize > $200000)) <> 0) Then
        Return Null
    EndIf
    local0 = readfile(arg0)
    If (local0 = $00) Then
        Return Null
    EndIf
    se_loadinvalid = $00
    local1 = (New se_script)
    se_vf_inst_n = (readint(local0) - $01)
    se_vf_func_ptr_n = (readint(local0) - $01)
    se_vf_static_n = (readint(local0) - $01)
    se_vf_label_n = (readint(local0) - $01)
    se_vf_public_n = (readint(local0) - $01)
    If (((((((((((se_vf_inst_n < $00) Or (se_vf_inst_n > $1869F)) Or (se_vf_func_ptr_n < $00)) Or (se_vf_func_ptr_n > $FFF)) Or (se_vf_static_n < $FFFFFFFF)) Or (se_vf_static_n > $FFF)) Or (se_vf_label_n < $FFFFFFFF)) Or (se_vf_label_n > $FFF)) Or (se_vf_public_n < $FFFFFFFF)) Or (se_vf_public_n > $FFF)) <> 0) Then
        closefile(local0)
        Delete local1
        Return Null
    EndIf
    Dim se_vf_a_inst.se_inst((Int max(0.0, (Float se_vf_inst_n))))
    Dim se_vf_a_func_ptr.se_funcptr((Int max(0.0, (Float se_vf_func_ptr_n))))
    Dim se_vf_a_static.se_value((Int max(0.0, (Float se_vf_static_n))))
    Dim se_vf_a_label.se_value((Int max(0.0, (Float se_vf_label_n))))
    Dim se_loadtransientlimit%(se_vf_inst_n)
    Dim se_loadowner%(se_vf_inst_n)
    For local6 = $00 To se_vf_inst_n Step $01
        se_loadtransientlimit(local6) = $FFFFFFFF
        se_loadowner(local6) = $FFFFFFFF
    Next
    For local6 = $00 To se_vf_inst_n Step $01
        se_vf_a_inst(local6) = se_createinst(local1, $00, Null, Null, Null)
    Next
    For local6 = $00 To se_vf_static_n Step $01
        se_vf_a_static(local6) = (New se_value)
    Next
    For local6 = $00 To se_vf_func_ptr_n Step $01
        local7 = se_readsafestring(local0)
        If (se_loadinvalid <> 0) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        If (se_canread(local0, $10) = $00) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        local8 = readint(local0)
        local9 = readint(local0)
        local10 = readint(local0)
        local11 = readint(local0)
        If (((((((((local8 < $00) Or (local8 > se_vf_inst_n)) Or (local9 < local8)) Or (local9 > se_vf_inst_n)) Or (local10 < $00)) Or (local10 > $1000)) Or (local11 < $00)) Or (local11 > local10)) <> 0) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        For local12 = local8 To local9 Step $01
            If (se_loadtransientlimit(local12) <> $FFFFFFFF) Then
                closefile(local0)
                se_deletescript(local1)
                Return Null
            EndIf
            se_loadtransientlimit(local12) = local10
            se_loadowner(local12) = local6
        Next
        se_vf_a_func_ptr(local6) = se_createfuncptr(local1, local7, se_vf_a_inst(local8), se_vf_a_inst(local9), local10, local11)
    Next
    For local6 = $00 To se_vf_label_n Step $01
        If (se_canread(local0, $04) = $00) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        local13 = readint(local0)
        If (((local13 < $00) Or (local13 > se_vf_inst_n)) <> 0) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        se_vf_a_label(local6) = (New se_value)
        se_vf_a_label(local6)\Field7 = se_vf_a_inst(local13)
        se_vf_a_label(local6)\Field9 = local13
    Next
    For local6 = $00 To se_vf_public_n Step $01
        local14 = se_readsafestring(local0)
        If (se_loadinvalid <> 0) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        If (se_canread(local0, $04) = $00) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        local15 = readint(local0)
        If (((local15 < $00) Or (local15 > se_vf_static_n)) <> 0) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        se_createpublic(local1, local14, se_vf_a_static(local15))
    Next
    For local6 = $00 To se_vf_inst_n Step $01
        se_loadinstindex = local6
        If (se_canread(local0, $01) = $00) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        local16 = readbyte(local0)
        se_vf_a_inst(local6)\Field0 = local16
        Select local16
            Case $1F
            Case $09,$0A,$18,$1B,$1E,$22
                se_vf_a_inst(local6)\Field1 = se_readarg(local0, $00)
            Case $01,$08,$14,$17,$19,$1A,$20,$21,$25,$23
                se_vf_a_inst(local6)\Field1 = se_readarg(local0, $00)
                se_vf_a_inst(local6)\Field2 = se_readarg(local0, $00)
            Case $02,$03,$04,$05,$06,$07,$0B,$0C,$0D,$0E,$0F,$10,$11,$12,$13,$15,$16,$1C,$1D,$24
                se_vf_a_inst(local6)\Field1 = se_readarg(local0, local16)
                se_vf_a_inst(local6)\Field2 = se_readarg(local0, $00)
                se_vf_a_inst(local6)\Field3 = se_readarg(local0, $00)
            Default
                se_loadinvalid = $01
        End Select
        If (se_loadinvalid <> 0) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        Select local16
            Case $18
                If (se_vf_a_inst(local6)\Field1\Field7 = Null) Then
                    se_loadinvalid = $01
                EndIf
                If (se_loadowner(local6) <> se_loadowner(se_vf_a_inst(local6)\Field1\Field9)) Then
                    se_loadinvalid = $01
                EndIf
            Case $19,$1A
                If (se_vf_a_inst(local6)\Field2\Field7 = Null) Then
                    se_loadinvalid = $01
                EndIf
                If (se_loadowner(local6) <> se_loadowner(se_vf_a_inst(local6)\Field2\Field9)) Then
                    se_loadinvalid = $01
                EndIf
            Case $1C
                If (((se_vf_a_inst(local6)\Field1\Field0 <> $09) Or (se_vf_a_inst(local6)\Field2\Field0 <> $01)) <> 0) Then
                    se_loadinvalid = $01
                EndIf
                If (((se_vf_a_inst(local6)\Field2\Field2 < $00) Or (se_vf_a_inst(local6)\Field2\Field2 > $40)) <> 0) Then
                    se_loadinvalid = $01
                EndIf
            Case $1D
                If (((se_vf_a_inst(local6)\Field1\Field0 <> $03) Or (se_vf_a_inst(local6)\Field2\Field0 <> $01)) <> 0) Then
                    se_loadinvalid = $01
                EndIf
                If (((se_vf_a_inst(local6)\Field2\Field2 < $00) Or (se_vf_a_inst(local6)\Field2\Field2 > $40)) <> 0) Then
                    se_loadinvalid = $01
                EndIf
            Case $23
                If (se_vf_a_inst(local6)\Field1\Field0 <> $01) Then
                    se_loadinvalid = $01
                EndIf
                If (((se_vf_a_inst(local6)\Field1\Field2 < $00) Or (se_vf_a_inst(local6)\Field1\Field2 > $40)) <> 0) Then
                    se_loadinvalid = $01
                EndIf
        End Select
        If (se_loadinvalid <> 0) Then
            closefile(local0)
            se_deletescript(local1)
            Return Null
        EndIf
        local19 = ((Str se_vf_a_inst(local6)\Field0) + ": ")
        If (se_vf_a_inst(local6)\Field1 <> Null) Then
            local19 = ((local19 + (Str se_vf_a_inst(local6)\Field1\Field0)) + ", ")
        EndIf
        If (se_vf_a_inst(local6)\Field2 <> Null) Then
            local19 = ((local19 + (Str se_vf_a_inst(local6)\Field2\Field0)) + ", ")
        EndIf
        If (se_vf_a_inst(local6)\Field3 <> Null) Then
            local19 = (local19 + (Str se_vf_a_inst(local6)\Field3\Field0))
        EndIf
    Next
    local1\Field4 = local1\Field2
    closefile(local0)
    Return local1
    Return Null
End Function
