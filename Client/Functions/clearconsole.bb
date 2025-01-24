Function clearconsole%()
    Local local0.consolemsg
    For local0 = Each consolemsg
        Delete local0
    Next
    consoler = $00
    consoleg = $FF
    consoleb = $FF
    createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg("Console commands: ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - help [page]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - teleport [room name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - roomlist", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - godmode [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - noclip [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - infinitestamina [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - noblink [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - notarget [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - noclipspeed [x] (default = 2.0)", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - wireframe [on / off]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - debughud [category]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - camerafog [x]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - heal", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - revive", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - asd", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - spawnitem [item name / ID]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - itemlist", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - 106retreat", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - disable173 / enable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - disable106 / enable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    createconsolemsg(" - spawn [NPC type]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    Return $00
End Function
