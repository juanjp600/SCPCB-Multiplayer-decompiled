Function udp_fillsteam%(arg0%)
    bs_csteamid_set(bs_steamid_dynamic, arg0, $01, $01)
    Return bs_steamid_dynamic
    Return $00
End Function
