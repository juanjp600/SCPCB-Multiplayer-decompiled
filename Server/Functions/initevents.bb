Function initevents%()
    Local local0.events
    If ((server\Field8 And (server\Field21 = $00)) <> 0) Then
        createevent("173", "173", $00, 0.0)
    EndIf
    If (server\Field21 = $00) Then
        createevent("alarm", "start", $00, 0.0)
    EndIf
    createevent("pocketdimension", "pocketdimension", $00, 0.0)
    createevent("tunnel106", "tunnel", $00, (((Float selecteddifficulty\Field3) * 0.1) + 0.07))
    If (rand($03, $01) < $03) Then
        createevent("lockroom173", "lockroom", $00, 0.0)
    EndIf
    createevent("lockroom173", "lockroom", $00, (((Float selecteddifficulty\Field3) * 0.5) + 0.3))
    createevent("room2trick", "room2", $00, 0.15)
    createevent("1048a", "room2", $00, 1.0)
    createevent("room2storage", "room2storage", $00, 0.0)
    createevent("lockroom096", "lockroom2", $00, 0.0)
    createevent("endroom106", "endroom", rand($00, $01), 0.0)
    createevent("room2poffices2", "room2poffices2", $00, 0.0)
    createevent("room2fan", "room2_2", $00, 1.0)
    createevent("room2elevator2", "room2elevator", $00, 0.0)
    createevent("room2elevator", "room2elevator", rand($01, $02), 0.0)
    createevent("room3storage", "room3storage", $00, 0.0)
    createevent("tunnel2smoke", "tunnel2", $00, 0.2)
    createevent("tunnel2", "tunnel2", rand($00, $02), 0.0)
    createevent("tunnel2", "tunnel2", $00, ((Float selecteddifficulty\Field3) * 0.2))
    createevent("room2doors173", "room2doors", $00, (((Float selecteddifficulty\Field3) * 0.4) + 0.5))
    createevent("room2offices2", "room2offices2", $00, 0.7)
    createevent("room2closets", "room2closets", $00, 0.0)
    createevent("room2cafeteria", "room2cafeteria", $00, 0.0)
    createevent("room3pitduck", "room3pit", $00, 0.0)
    createevent("room3pit1048", "room3pit", $01, 0.0)
    createevent("room2offices3", "room2offices3", $00, 1.0)
    createevent("room2servers", "room2servers", $00, 0.0)
    createevent("room3servers", "room3servers", $00, 0.0)
    createevent("room3servers", "room3servers2", $00, 0.0)
    createevent("room3tunnel", "room3tunnel", $00, 0.08)
    createevent("room4", "room4", $00, 0.0)
    If (rand($05, $01) < $05) Then
        Select rand($03, $01)
            Case $01
                createevent("682roar", "tunnel", rand($00, $02), 0.0)
            Case $02
                createevent("682roar", "room3pit", rand($00, $02), 0.0)
            Case $03
                createevent("682roar", "room2z3", $00, 0.0)
        End Select
    EndIf
    createevent("testroom173", "room2testroom2", $00, 1.0)
    createevent("room2tesla", "room2tesla", $00, 0.9)
    createevent("room2nuke", "room2nuke", $00, 0.0)
    If (rand($05, $01) < $05) Then
        createevent("coffin106", "coffin", $00, 0.0)
    Else
        createevent("coffin", "coffin", $00, 0.0)
    EndIf
    createevent("checkpoint", "checkpoint1", $00, 1.0)
    createevent("checkpoint", "checkpoint2", $00, 1.0)
    createevent("room3door", "room3", $00, 0.1)
    createevent("room3door", "room3tunnel", $00, 0.1)
    If (rand($02, $01) = $01) Then
        createevent("106victim", "room3", rand($01, $02), 0.0)
        createevent("106sinkhole", "room3_2", rand($02, $03), 0.0)
    Else
        createevent("106victim", "room3_2", rand($01, $02), 0.0)
        createevent("106sinkhole", "room3", rand($02, $03), 0.0)
    EndIf
    createevent("106sinkhole", "room4", rand($01, $02), 0.0)
    createevent("room079", "room079", $00, 0.0)
    createevent("room049", "room049", $00, 0.0)
    createevent("room012", "room012", $00, 0.0)
    createevent("room035", "room035", $00, 0.0)
    createevent("008", "008", $00, 0.0)
    createevent("room106", "room106", $00, 0.0)
    createevent("pj", "roompj", $00, 0.0)
    createevent("914", "914", $00, 0.0)
    createevent("buttghost", "room2toilets", $00, 0.0)
    createevent("toiletguard", "room2toilets", $01, 0.0)
    createevent("room2pipes106", "room2pipes", rand($00, $03), 0.0)
    createevent("room2pit", "room2pit", $00, (((Float selecteddifficulty\Field3) * 0.4) + 0.4))
    createevent("testroom", "testroom", $00, 0.0)
    createevent("room2tunnel", "room2tunnel", $00, 0.0)
    createevent("room2ccont", "room2ccont", $00, 0.0)
    createevent("gateaentrance", "gateaentrance", $00, 0.0)
    createevent("gatea", "gatea", $00, 0.0)
    createevent("exit1", "exit1", $00, 0.0)
    createevent("room205", "room205", $00, 0.0)
    createevent("room860", "room860", $00, 0.0)
    createevent("room966", "room966", $00, 0.0)
    createevent("room1123", "room1123", $00, 0.0)
    createevent("room2tesla", "room2tesla_lcz", $00, 0.9)
    createevent("room2tesla", "room2tesla_hcz", $00, 0.9)
    createevent("room4tunnels", "room4tunnels", $00, 0.0)
    createevent("room_gw", "room2gw", $00, 1.0)
    createevent("dimension1499", "dimension1499", $00, 0.0)
    createevent("room1162", "room1162", $00, 0.0)
    createevent("room2scps2", "room2scps2", $00, 0.0)
    createevent("room_gw", "room3gw", $00, 1.0)
    createevent("room2sl", "room2sl", $00, 0.0)
    createevent("medibay", "medibay", $00, 0.0)
    createevent("room2shaft", "room2shaft", $00, 0.0)
    createevent("room1lifts", "room1lifts", $00, 0.0)
    createevent("room2gw_b", "room2gw_b", rand($00, $01), 0.0)
    createevent("096spawn", "room4pit", $00, (((Float selecteddifficulty\Field3) * 0.2) + 0.6))
    createevent("096spawn", "room3pit", $00, (((Float selecteddifficulty\Field3) * 0.2) + 0.6))
    createevent("096spawn", "room2pipes", $00, (((Float selecteddifficulty\Field3) * 0.2) + 0.4))
    createevent("096spawn", "room2pit", $00, (((Float selecteddifficulty\Field3) * 0.2) + 0.5))
    createevent("096spawn", "room3tunnel", $00, (((Float selecteddifficulty\Field3) * 0.2) + 0.6))
    createevent("096spawn", "room4tunnels", $00, (((Float selecteddifficulty\Field3) * 0.2) + 0.7))
    createevent("096spawn", "tunnel", $00, (((Float selecteddifficulty\Field3) * 0.2) + 0.6))
    createevent("096spawn", "tunnel2", $00, (((Float selecteddifficulty\Field3) * 0.2) + 0.4))
    createevent("096spawn", "room3z2", $00, (((Float selecteddifficulty\Field3) * 0.2) + 0.7))
    createevent("room2pit", "room2_4", $00, (((Float selecteddifficulty\Field3) * 0.4) + 0.4))
    createevent("room2offices035", "room2offices", $00, 0.0)
    createevent("room2pit106", "room2pit", $00, (((Float selecteddifficulty\Field3) * 0.1) + 0.07))
    createevent("room1archive", "room1archive", $00, 1.0)
    For local0 = Each events
        local0\Field24 = $01
    Next
    Return $00
End Function
