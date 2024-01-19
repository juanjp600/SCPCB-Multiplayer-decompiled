Function updatequery%()
    Local local0.querys
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5.scriptsthread
    Local local6.scriptsthread
    Local local7%
    Local local8%
    Local local9%
    Local local10$
    For local0 = Each querys
        If (filepos(local0\Field3) >= local0\Field1) Then
            closefile(local0\Field3)
            freebank(local0\Field10)
            If (local0\Field9 <> $00) Then
                local1 = readfile((("multiplayer\serversdata\" + local0\Field0) + ".packed"))
                If (local1 <> $00) Then
                    local2 = createbank(local0\Field1)
                    readbytes(local2, local1, $00, local0\Field1)
                    closefile(local1)
                EndIf
                local3 = zipapi_uncompress(local2, local0\Field9)
                If (local3 <> $00) Then
                    local1 = writefiledir(("multiplayer\serversdata\" + local0\Field0))
                    writebytes(local3, local1, $00, local0\Field9)
                    closefile(local1)
                    deletefile((("multiplayer\serversdata\" + local0\Field0) + ".packed"))
                EndIf
            ElseIf (local0\Field8 <> 0) Then
                local4 = $00
                For local5 = Each scriptsthread
                    If (local5\Field1 = ("multiplayer\serversdata\" + local0\Field0)) Then
                        local4 = $01
                        Exit
                    EndIf
                Next
                If (local4 = $00) Then
                    local6 = (New scriptsthread)
                    local6\Field0 = se_loadscriptexec(("multiplayer\serversdata\" + local0\Field0))
                    local6\Field1 = ("multiplayer\serversdata\" + local0\Field0)
                    skynet_onload($00)
                    init_publics_for_script(local6\Field0)
                    public_inqueue($13, $00)
                    public_update_current(local6\Field0, $00)
                    public_clear()
                    deletefile(("multiplayer\serversdata\" + local0\Field0))
                EndIf
            EndIf
            public_inqueue($15, $00)
            public_addparam(local0\Field0, $03)
            callback()
            udp_writebyte($6F)
            udp_writebyte(networkserver\Field28)
            udp_writeint(local0\Field4)
            udp_writeint(local0\Field1)
            udp_writeshort((Int networkserver\Field41))
            udp_sendmessage($00)
            Delete local0
            Exit
        EndIf
        Exit
    Next
    local7 = $00
    local8 = $00
    For local0 = Each querys
        If (local0\Field3 <> $00) Then
            local7 = (local7 + local0\Field1)
            local8 = (local8 + filepos(local0\Field3))
        EndIf
    Next
    If (previousdownloadpos[$00] = local8) Then
        If (previousdownloadpos[$01] = $00) Then
            previousdownloadpos[$01] = (millisecs() + $1388)
        ElseIf (previousdownloadpos[$01] < millisecs()) Then
            previousdownloadpos[$02] = (millisecs() + $1388)
        EndIf
    Else
        previousdownloadpos[$00] = $00
        previousdownloadpos[$01] = $00
        previousdownloadpos[$02] = $00
    EndIf
    previousdownloadpos[$00] = local8
    If (((local8 <> $00) And (previousdownloadpos[$02] < millisecs())) <> 0) Then
        If (downloadspeedupdate < millisecs()) Then
            downloadspeedbytes = $00
            local9 = $00
            For local0 = Each querys
                If (local0\Field6 <> $00) Then
                    downloadspeedbytes = (downloadspeedbytes + local0\Field6)
                    local9 = (local9 + $01)
                    local0\Field6 = $00
                EndIf
            Next
            downloadspeedbytes = (Int ((Float downloadspeedbytes) / max((Float local9), 1.0)))
            downloadspeedupdate = (millisecs() + $3E8)
        EndIf
        local10 = (((("Loading files (" + (Str getdownloadspeed((Float downloadspeedbytes)))) + " MB/s, ") + (Str (Int countpercent(100.0, (Float local8), (Float local7))))) + "% / 100%)...")
        color($FF, $FF, $FF)
        aasetfont(font1)
        aatext((Int ((Float (graphicwidth - aastringwidth(local10))) - (30.0 * menuscale))), (graphicheight - $2D), local10, $00, $00, 1.0)
        loading_frame = playanimimage(mpimg\Field9, (Int ((Float (graphicwidth - aastringwidth(local10))) - (70.0 * menuscale))), (graphicheight - $32), (0.05 * fpsfactor), loading_frame, 11.0)
    EndIf
    Return $00
End Function
