Function clearserver%()
    Local local0.players
    Local local1.servers
    Local local2.snd3d
    Local local3.scriptsthread
    Local local4.workshopthread
    Local local5.draws
    Local local6.draws
    Local local7.multiplayer_texts
    Local local8.multiplayer_texts
    For local0 = Each players
        multiplayer_disconnectplayer(local0)
    Next
    networkserver\Field15 = $00
    If (mainmenuopen = $00) Then
        playsound_strict(buttonsfx)
        nullgame($00)
        menuopen = $00
    EndIf
    For local1 = Each servers
        If (local1\Field15 <> 0) Then
            multiplayer_list_deleteserver(local1)
        EndIf
    Next
    flushkeys()
    udp_setstream(udp_network, $00, $00, $00, $01)
    cancelsteamticket()
    networkserver\Field66 = $00
    networkserver\Field57 = $00
    networkserver\Field18 = $00
    networkserver\Field42 = $00
    networkserver\Field33 = $00
    networkserver\Field32 = $00
    networkserver\Field34 = $00
    networkserver\Field35 = $00
    networkserver\Field31 = $00
    networkserver\Field22 = $00
    networkserver\Field36 = 0.0
    networkserver\Field37 = 0.0
    networkserver\Field38 = 0.0
    networkserver\Field28 = $00
    networkserver\Field44 = ""
    networkserver\Field45 = $00
    networkserver\Field21 = ""
    networkserver\Field47 = $00
    networkserver\Field49 = $00
    networkserver\Field50 = $00
    networkserver\Field13 = $00
    networkserver\Field15 = $00
    networkserver\Field48 = $03
    networkserver\Field52 = $00
    networkserver\Field64 = $00
    networkserver\Field65 = $00
    discord_api_setstate("", $02)
    secondarylighton = 1.0
    rcon\Field0 = $00
    currentpositionid = $00
    lockmouse = $00
    menu_open_type = $00
    mainmenuopen = $01
    mainmenutab = $01
    gameload = $00
    passwordmenu = $00
    connectmenu = $00
    ready = "Not Ready"
    selected_p_page = $00
    script_count = $00
    nocheat = $00
    playerintercom\Field2 = $4E20
    outscp = $01
    chatedittype = $00
    b_br\Field9 = $00
    msgtimer = 0.0
    b_br\Field0 = 0.0
    newyearindex = isanewyear()
    halloweenindex = isahalloween()
    b_br\Field5 = $00
    b_br\Field7 = $00
    For local2 = Each snd3d
        If (local2\Field0 = $00) Then
            stopchannel(local2\Field2)
            Delete local2
        Else
            fsound_stopsound(local2\Field2)
            fsound_stream_close(local2\Field1)
            Delete local2
        EndIf
    Next
    Delete Each chatmessage
    Delete Each announcements
    Delete Each multiplayer_objects
    deletequerys()
    For local3 = Each scriptsthread
        se_deletescript(local3\Field0)
        Delete local3
    Next
    For local4 = Each workshopthread
        If (local4\Field2 = Null) Then
            local4\Field2 = se_loadscriptexec(local4\Field0)
            skynet_onload($01)
            init_publics_for_script(local4\Field2)
        EndIf
    Next
    For local5 = Each draws
        If (local5\Field2 <> $00) Then
            freeimage(local5\Field2)
        EndIf
        For local6 = Each draws
            If (((local6\Field2 = local5\Field2) And (local6 <> local5)) <> 0) Then
                local6\Field2 = $00
            EndIf
        Next
        Delete local5
    Next
    For local7 = Each multiplayer_texts
        If (local7\Field2 <> $00) Then
            freefont(local7\Field2)
        EndIf
        For local8 = Each multiplayer_texts
            If (((local7\Field2 = local8\Field2) And (local7 <> local8)) <> 0) Then
                local8\Field2 = $00
            EndIf
        Next
        Delete local7
    Next
    ws_checksubscribeditems($01)
    bytestreamreset(microbyte)
    For local1 = Each servers
        If (((local1\Field0 = $01) Or (local1\Field0 = $05)) <> 0) Then
            multiplayer_list_updateserver(local1, $1388, $01)
        EndIf
    Next
    Return $00
End Function
