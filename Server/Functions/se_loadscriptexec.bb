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
    Local local13$
    Local local14%
    Local local15%
    Local local17$
    local0 = readfile(arg0)
    If (local0 = $00) Then
        Return Null
    EndIf
    local1 = (New se_script)
    se_vf_inst_n = (readint(local0) - $01)
    se_vf_func_ptr_n = (readint(local0) - $01)
    se_vf_static_n = (readint(local0) - $01)
    se_vf_label_n = (readint(local0) - $01)
    se_vf_public_n = (readint(local0) - $01)
    Dim se_vf_a_inst.se_inst(se_vf_inst_n)
    Dim se_vf_a_func_ptr.se_funcptr(se_vf_func_ptr_n)
    Dim se_vf_a_static.se_value(se_vf_static_n)
    Dim se_vf_a_label.se_value(se_vf_label_n)
    For local6 = $00 To se_vf_inst_n Step $01
        se_vf_a_inst(local6) = se_createinst(local1, $00, Null, Null, Null)
    Next
    For local6 = $00 To se_vf_static_n Step $01
        se_vf_a_static(local6) = (New se_value)
    Next
    For local6 = $00 To se_vf_func_ptr_n Step $01
        local7 = readstring(local0)
        local8 = readint(local0)
        local9 = readint(local0)
        local10 = readint(local0)
        local11 = readint(local0)
        se_vf_a_func_ptr(local6) = se_createfuncptr(local1, local7, se_vf_a_inst(local8), se_vf_a_inst(local9), local10, local11)
    Next
    For local6 = $00 To se_vf_label_n Step $01
        local12 = readint(local0)
        se_vf_a_label(local6) = (New se_value)
        se_vf_a_label(local6)\Field6 = se_vf_a_inst(local12)
    Next
    For local6 = $00 To se_vf_public_n Step $01
        local13 = readstring(local0)
        local14 = readint(local0)
        se_createpublic(local1, local13, se_vf_a_static(local14))
    Next
    For local6 = $00 To se_vf_inst_n Step $01
        local15 = readbyte(local0)
        se_vf_a_inst(local6)\Field0 = local15
        Select local15
            Case $09,$0A,$18,$1B,$1E,$22
                se_vf_a_inst(local6)\Field1 = se_readarg(local0, $00)
            Case $01,$08,$14,$17,$19,$1A,$20,$21,$25,$23
                se_vf_a_inst(local6)\Field1 = se_readarg(local0, $00)
                se_vf_a_inst(local6)\Field2 = se_readarg(local0, $00)
            Case $02,$03,$04,$05,$06,$07,$0B,$0C,$0D,$0E,$0F,$10,$11,$12,$13,$15,$16,$1C,$1D,$23,$24
                se_vf_a_inst(local6)\Field1 = se_readarg(local0, local15)
                se_vf_a_inst(local6)\Field2 = se_readarg(local0, $00)
                se_vf_a_inst(local6)\Field3 = se_readarg(local0, $00)
        End Select
        local17 = ((Str se_vf_a_inst(local6)\Field0) + ": ")
        If (se_vf_a_inst(local6)\Field1 <> Null) Then
            local17 = ((local17 + (Str se_vf_a_inst(local6)\Field1\Field0)) + ", ")
        EndIf
        If (se_vf_a_inst(local6)\Field2 <> Null) Then
            local17 = ((local17 + (Str se_vf_a_inst(local6)\Field2\Field0)) + ", ")
        EndIf
        If (se_vf_a_inst(local6)\Field3 <> Null) Then
            local17 = (local17 + (Str se_vf_a_inst(local6)\Field3\Field0))
        EndIf
        debuglog(local17)
    Next
    local1\Field4 = local1\Field2
    local1\Field9 = readline(local0)
    If (local1\Field9 = "") Then
        local1\Field9 = "NULL"
    EndIf
    closefile(local0)
    Return local1
    Return Null
End Function
