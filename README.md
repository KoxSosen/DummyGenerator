# DummyGenerator

Generates dummy punishments to your LibertyBans database.

At the moments. punishments are added with;
- Random victims based on UUIDs,
- Random reasons,
- Random durations.

## Setup

Download the fatjar from the releases section. Run it for the first time, then configure the `sql.yml`
file. Then, follow the syntax mentioned upon boot.

## Examples:

```
ban:20 - Generates 20 bans with random rasons, victinms, and durations.
mute:4 - Generates 4 random mutes with random victims, durations, and reasons.
```